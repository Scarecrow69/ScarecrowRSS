package hu.nt.rss.ScarecrowRSS.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import hu.nt.rss.ScarecrowRSS.RSSUtils;
import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;
import hu.nt.rss.ScarecrowRSS.main.parser.RssFeedParser;
import hu.nt.rss.ScarecrowRSS.main.parser.XMLParserException;
import hu.nt.rss.ScarecrowRSS.search.data.Link;

public class RssLogicImpl implements RssLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5277081480097354628L;
	private Link link;
	private String rawXML;
	private RssChannel rss;
	
	public RssLogicImpl() {
		rawXML = "";
		link = new Link();
	}
	
	public RssLogicImpl(Link l) {
		link = l;
	}
	
	@Override
	public void setLink(Link link) {
		this.link = link;
	}

	@Override
	public void loadXML() {
		try {
			URL url = new URL(link.getUrl().getValue());
			InputStream is = url.openStream();
			rawXML = RSSUtils.getInstance().getStringFromInputStream(is);
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.err.println("Nem lehet elérni a szervert a címen!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Stream kezelési hiba!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void makeRSS() throws XMLParserException {
		RssFeedParser parser = new RssFeedParser();
		rss = parser.getRSS(rawXML);
	}

	@Override
	public String getRawXML() {
		return rawXML;
	}

	@Override
	public RssChannel getRSS() {
		return rss;
	}

}
