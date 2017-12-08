package hu.nt.rss.ScarecrowRSS.search.ui;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Kereső lap grafikus felület
 * @author nagytamas
 *
 */
public class SearchLayout  extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7468408515456582331L;
	
	/**
	 * 
	 */
	public SearchLayout()
	{
		this.setResponsive(true);
		this.setMargin(true);
		this.setSizeFull();	
		this.addStyleName("maincolor");
		
		VerticalLayout panel = getPanel();
		this.addComponent(panel);
		this.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
	}
	
	private VerticalLayout getPanel()
	{
		VerticalLayout panel = new VerticalLayout();
		panel.setResponsive(true);
		panel.setWidth("100%");
		panel.setMargin(true);
		panel.addStyleName("border");
		
		Label h1 = new Label("<h1>ScarecrowRSS</h1>",ContentMode.HTML);
		h1.setWidth("100%");
		
		SearchBar bar = new SearchBar();
		bar.setWidth("100%");
		
		panel.addComponents(h1,bar);
		panel.setComponentAlignment(h1, Alignment.MIDDLE_CENTER);
		panel.setComponentAlignment(bar, Alignment.MIDDLE_CENTER);
		
		return panel;
	}

	
}
