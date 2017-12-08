package hu.nt.rss.ScarecrowRSS.main.ui;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import hu.nt.rss.ScarecrowRSS.RSSUtils;
import hu.nt.rss.ScarecrowRSS.main.data.RssItem;

public class ItemLayout extends VerticalLayout {

	private static final long serialVersionUID = 6147747074532741555L;

	private RssItem item;
	
	public ItemLayout()
	{
		this.setMargin(true);
		this.setSpacing(true);
		this.setHeightUndefined();
		this.setWidth(100, Unit.PERCENTAGE);
//		this.setSizeFull();
	}
	
	public void setItem(RssItem item)
	{
		this.item = item;
		
		Label LTitle = new Label("Cím: " + item.getTitle());
		Label LDesc = new Label("Leírás: " + item.getDescription(),ContentMode.HTML);
		Label LAuthor = new Label("Szerző: "+ item.getAuthor());
		Label LPubDate = new Label("Publikálás ideje:" + RSSUtils.getInstance().getStringFromDate(item.getPubDate()));
		
		this.addComponents(LTitle, LDesc, LAuthor, LPubDate);
	}
	
	public RssItem getItem()
	{
		return item;
	}
	
}
