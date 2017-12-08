package hu.nt.rss.ScarecrowRSS.search.ui.components;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.TextField;

public class UrlTextField extends TextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2229534598456314184L;
	
	
	public UrlTextField()
	{
		init();
	}
	
	public UrlTextField(ObjectProperty<?> property)
	{
		init();
		this.setPropertyDataSource(property);
	}
	
	private void init()
	{
		this.setInputPrompt("RSS hírcsatorna címe...");
		this.setSizeFull();
		this.setImmediate(true);
	}

}
