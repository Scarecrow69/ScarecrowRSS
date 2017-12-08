package hu.nt.rss.ScarecrowRSS.main.ui;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import hu.nt.rss.ScarecrowRSS.main.RssLogic;
import hu.nt.rss.ScarecrowRSS.main.RssLogicImpl;
import hu.nt.rss.ScarecrowRSS.main.parser.XMLParserException;
import hu.nt.rss.ScarecrowRSS.search.data.Link;

public class MainLayout extends HorizontalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585206545931340333L;

	private RssLogic rssLogic;
	private LeftPanel lp = new LeftPanel();
	private RightPanel rp = new RightPanel();
	
	
	public MainLayout()
	{
		init();
		rssLogic = new RssLogicImpl();
	}
	
	public MainLayout(Link link)
	{
		init();
		rssLogic = new RssLogicImpl(link);
		rssLogic.loadXML();
		try {
			rssLogic.makeRSS();
			setSubPanel();
		} catch (XMLParserException e) {
			e.printStackTrace();
			Notification.show("Ez az RSS hírcsatorna nem támogatott!","Régi verziószám",Type.ERROR_MESSAGE);
		}
	}
	
	private void init()
	{
//		this.setSizeFull();
		this.setWidth(100, Unit.PERCENTAGE);
		this.setHeightUndefined();
		
		buildLayouts();
	}
	
	private void buildLayouts()
	{
		lp.addStyleName("border");
		rp.addStyleName("border");
		
		this.addComponents(lp,rp);
		this.setComponentAlignment(lp, Alignment.TOP_LEFT);
		this.setExpandRatio(rp, 1.2f);
		this.setExpandRatio(lp, 0.4f);
		
	}
	
	private void setSubPanel()
	{
		lp.setChannelPanel(rssLogic.getRSS());
		lp.setListLayout(rssLogic.getRSS(), rp);
	}
	
}
