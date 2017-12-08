package hu.nt.rss.ScarecrowRSS.search.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

public class SearchButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6918919259393534759L;
	
	public SearchButton()
	{
		init();
	}
	
	private void init()
	{
		this.setCaptionAsHtml(true);
		this.setCaption(FontAwesome.ARROW_RIGHT.getHtml());
	}
	

}
