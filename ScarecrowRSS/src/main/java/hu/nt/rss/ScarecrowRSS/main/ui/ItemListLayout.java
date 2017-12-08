package hu.nt.rss.ScarecrowRSS.main.ui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.VerticalLayout;

import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;
import hu.nt.rss.ScarecrowRSS.main.data.RssItem;

public class ItemListLayout extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3324994182529990658L;
	
	public ItemListLayout()
	{
		this.setMargin(true);
		this.setSpacing(true);
//		this.setSizeFull();ű
		this.setHeightUndefined();
	}
	
	public void uploadList(RssChannel channel, RightPanel rp)
	{
		for(RssItem item : channel.getItems())
		{
			ItemLayout il = new ItemLayout();
			il.setItem(item);
			il.addStyleName("border");
			
			il.addLayoutClickListener(new LayoutClickListener() {
				
				private static final long serialVersionUID = -8986145717086954202L;

				@Override
				public void layoutClick(LayoutClickEvent event) {
					rp.addTab(il.getItem().getTitle(), il.getItem().getLink());
				}
			});
			this.addComponent(il);
		}
	}

}
