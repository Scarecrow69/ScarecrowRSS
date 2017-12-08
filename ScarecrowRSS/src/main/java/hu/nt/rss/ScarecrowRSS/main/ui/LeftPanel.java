package hu.nt.rss.ScarecrowRSS.main.ui;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;

public class LeftPanel extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3366392091867349976L;

	private ChannelPanel channel;
	private ItemListLayout list;
	
	public LeftPanel()
	{
		this.setResponsive(true);
//		this.setSizeFull();
		this.setWidth(100, Unit.PERCENTAGE);
		this.setHeightUndefined();
		
		
		channel = new ChannelPanel();
		this.addComponent(channel);
		
		list = new ItemListLayout();
		this.addComponent(list);
	}
	
	public void setChannelPanel(RssChannel rss)
	{
		try {
			channel.addLabels(rss);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("Hiba történt :(", "Nincs megjeleníthető adattartalom",Type.ERROR_MESSAGE);
		}
	}
	
	public void setListLayout(RssChannel rss, RightPanel rp)
	{
		list.uploadList(rss, rp);
	}
	
}
