package hu.nt.rss.ScarecrowRSS.main.ui;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import hu.nt.rss.ScarecrowRSS.RSSUtils;
import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;

public class ChannelPanel extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5889073536702693472L;
	
	
	
	public ChannelPanel() {
		this.setMargin(true);
		this.setResponsive(true);
		this.setSpacing(true);
	}
	
	
	public void addLabels(RssChannel rss) throws Exception
	{
		if(rss == null)
			throw new Exception("Üres RSS!");

		if(rss.getImage().getUrl() != null){
			Image image = new Image(rss.getImage().getTitle(), new ExternalResource(rss.getImage().getUrl()));
			this.addComponent(image);
		}
		
		
		Label Ltitle = new Label("Cím: " + rss.getTitle());
		Ltitle.setReadOnly(true);
		
		Label Llink = new Label("Link: " + rss.getLink());
		Llink.setReadOnly(true);
		
		Label Ldescription = new Label("Leírás: " + rss.getDescription());
		Ldescription.setReadOnly(true);
		
		Label Llanguage = new Label("Nyelv: " + rss.getLanguage());
		Llanguage.setReadOnly(true);
		
		Label Lcopyright = new Label("Copyright: " + rss.getCopyright());
		Lcopyright.setReadOnly(true);
		
		this.addComponents(Ltitle,Ldescription, Llink, Llanguage, Lcopyright);

		if(rss.getPubDate() != null)
		{
			Label LpubDate = new Label("Publikáció ideje: " + RSSUtils.getInstance().getStringFromDate(rss.getPubDate()));
			LpubDate.setReadOnly(true);
			this.addComponent(LpubDate);
		}
		
	}
}
