package hu.nt.rss.ScarecrowRSS.main.ui;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class RightPanel extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8318752593311609828L;

	private TabSheet tab;
	
	public RightPanel()
	{
		this.setResponsive(true);
		this.setSizeFull();
		setTab();
	}
	
	private void setTab()
	{
		tab = new TabSheet();
		tab.setHeight(100,Unit.PERCENTAGE);
		tab.addStyleName(ValoTheme.TABSHEET_ONLY_SELECTED_TAB_IS_CLOSABLE);
		tab.addStyleName(ValoTheme.TABSHEET_FRAMED);
		
		this.addComponent(tab);
	}
	
	public void addTab(String title, String url)
	{
		BrowserFrame bf = new BrowserFrame(title,new ExternalResource(url));
		bf.setSizeFull();
		tab.addTab(bf, title).setClosable(true);
	}
	
}
