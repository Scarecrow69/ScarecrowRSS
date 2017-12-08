package hu.nt.rss.ScarecrowRSS.main.parser;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import hu.nt.rss.ScarecrowRSS.RSSUtils;
import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;
import hu.nt.rss.ScarecrowRSS.main.data.RssElement;
import hu.nt.rss.ScarecrowRSS.main.data.RssEnclosure;
import hu.nt.rss.ScarecrowRSS.main.data.RssImage;
import hu.nt.rss.ScarecrowRSS.main.data.RssItem;

public class RssFeedParser {

	private RssChannel rss;
	
	public RssFeedParser() {
		rss = new RssChannel();
	}

	public RssChannel getRSS(String xml) throws XMLParserException {
		boolean isChannel = false; // az XML adatszerkezet channel tag jelölése
		
		try {
			// xml factory inicalizálása
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();

			// event reader beállítása
			if (xml != null) {
				XMLEventReader reader = inputFactory.createXMLEventReader(new StringReader(xml));

				Map<String, String> item = new HashMap<>();
				
				// xml dokumentum olvasása
				while (reader.hasNext()) {
					XMLEvent event = reader.nextEvent();
					
					if (event.isStartElement()) {
						
						StartElement element = event.asStartElement();
						String qName = element.getName().getLocalPart();
						
						
						switch (qName.toLowerCase()) {
						case "rss":
							checkRssVersion(element); // verziószám ellenőrzése
							break;

						case RssElement.Channel.CHANNEL:
							isChannel = true;
							break;
							

						case RssElement.Item.ITEM:
							if(isChannel)
							{
								loadRssChannel(item); //channel lezárása
								item.clear();
								isChannel = false;
							}
							break;
							
						case RssElement.IMAGE:
							if(isChannel)
							{
								loadRssChannel(item);
								item.clear();
							}
						break;
						
						default:
							item.put(qName, getData(event, reader));
							break;
						}
						
						
					} else if (event.isEndElement()) {
						EndElement element = event.asEndElement();
						String qName = element.getName().getLocalPart();
						
						if(qName.equalsIgnoreCase(RssElement.Item.ITEM))
						{
							rss.getItems().add(loadRssItem(item));
							item.clear();
						} else if(qName.equalsIgnoreCase(RssElement.IMAGE))
						{
							rss.setImage(loadImage(item));
							item.clear();
						}
					} 
				}
			}
			else
				System.err.println("Üres XML adat!");
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		System.out.println(rss.toString());
		
		return rss;
	}
	
		
	/**
	 * Az XML RSS verziójának ellenőrzése
	 * @param element
	 * @return
	 * @throws XMLParserException0
	 */
	private void checkRssVersion(StartElement element) throws XMLParserException
	{
		@SuppressWarnings("unchecked")
		Iterator<Attribute> it= element.getAttributes();
		while(it.hasNext())
		{
			Attribute at = it.next();
			if(at.getName().getLocalPart().equalsIgnoreCase("version"))
			{
				if(at.getValue().startsWith("2."))
					System.out.println("RSS version: " + at.getValue());
				else
						throw new XMLParserException("Verzió nem megfelelő!");
			}
		}
		
	}
	
	/**
	 * RSS chanel részének feltölrtése
	 * @param mapping
	 * @return
	 */
	private void loadRssChannel(Map<String, String> mapping)
	{
		for(String key : mapping.keySet())
		{
			switch (key) {
			case RssElement.DESCRIPTION:
				if(this.rss.getDescription().isEmpty())
					this.rss.setDescription(mapping.get(key));
				break;

			case RssElement.LINK:
				if(this.rss.getLink().isEmpty())
					this.rss.setLink(mapping.get(key));
				break;				
				
			case RssElement.PUBDATE:
				if(this.rss.getPubDate() == null)
					this.rss.setPubDate(RSSUtils.getInstance().getDateFromRssString(mapping.get(key)));
				break;	
				
			case RssElement.TITLE:
				if(this.rss.getTitle().isEmpty())
					this.rss.setTitle(mapping.get(key));
				break;	
				
			case RssElement.Channel.COPYRIGHT:
				if(this.rss.getCopyright().isEmpty())
					this.rss.setCopyright(mapping.get(key));
				break;	
				
			case RssElement.Channel.LANGUAGE:
				if(this.rss.getLanguage().isEmpty())
					this.rss.setLanguage(mapping.get(key));
				break;	
				
			default:
				System.err.println("Ilyen elem nincs meghatározva!" + key);
				break;
			}
		}
	}
	
	/**
	 * RssItem feltöltése
	 * @param map
	 * @return
	 */
	private RssItem loadRssItem(Map<String, String> map)
	{
		RssItem item = new RssItem();
		
		for(String key : map.keySet())
		{
			switch (key) {
			case RssElement.DESCRIPTION:
				item.setDescription(map.get(key));
				break;
				
			case RssElement.LINK:
				item.setLink(map.get(key));
				break;	

			case RssElement.PUBDATE:
				item.setPubDate(RSSUtils.getInstance().getDateFromRssString(map.get(key)));
				break;	
				
			case RssElement.TITLE:
				item.setTitle(map.get(key));
				break;	
			
			case RssElement.Item.AUTHOR:
				item.setAuthor(map.get(key));
				break;	
				
			case RssElement.Item.GUID:
				item.setGuid(map.get(key));
				break;	
				
			default:
				System.err.println("Ilyen elem nincs meghatározva!" + key);
				break;
			}
		}
		
		return item;
	}
	
	/**
	 * Channel elem
	 * @param map
	 * @return
	 */
	private RssImage loadImage(Map<String, String> map)
	{
		RssImage img = new RssImage();
		
		for(String key : map.keySet())
		{
			img.setDescription(map.get(key));
			img.setHeight(map.get(key));
			img.setLink(map.get(key));
			img.setTitle(map.get(key));
			img.setWidth(map.get(key));
			img.setUrl(map.get(key));
		}
		
		return img;
	}
	
	
	/**
	 * 
	 * @param event
	 * @param reader
	 * @return
	 * @throws XMLStreamException
	 */
	private String getData(XMLEvent event, XMLEventReader reader) throws XMLStreamException
	{
		String result = "";
		event = reader.nextEvent();
		if(event.isCharacters())
		{
			result = event.asCharacters().getData();
		}
		return result;
	}
	
}
