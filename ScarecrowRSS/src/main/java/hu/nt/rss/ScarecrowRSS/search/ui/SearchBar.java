package hu.nt.rss.ScarecrowRSS.search.ui;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import hu.nt.rss.ScarecrowRSS.main.ui.MainLayout;
import hu.nt.rss.ScarecrowRSS.search.SearchBLogic;
import hu.nt.rss.ScarecrowRSS.search.SearchBLogicImpl;
import hu.nt.rss.ScarecrowRSS.search.ui.components.SearchButton;
import hu.nt.rss.ScarecrowRSS.search.ui.components.UrlTextField;

public class SearchBar extends HorizontalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SearchBLogic controller;
	
	//components
	private UrlTextField urlField;
	private SearchButton loadLink;
	/**
	 * 
	 */
	public SearchBar()
	{
		init();
		
		urlField = new UrlTextField(controller.getLink().getUrl());
		urlField.addShortcutListener(addEnterKeyListener());
		
		loadLink = new SearchButton();
		loadLink.addClickListener(setButtonEvent());
		
		this.addComponents(urlField,loadLink);
		this.setComponentAlignment(loadLink, Alignment.MIDDLE_RIGHT);
		this.setExpandRatio(urlField, 2.0f);
	
	}
	
	private void init()
	{
		controller = new SearchBLogicImpl();
		this.setResponsive(true);
		this.addStyleName("debugcolor");
	}
	
	/**
	 *  A textfield esemény figyelőjének beállítása
	 */
	private ShortcutListener addEnterKeyListener()
	{
		return new ShortcutListener("ENTER",KeyCode.ENTER,null) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 107742397544526625L;

			@Override
			public void handleAction(Object sender, Object target) {
				openURL();
			}
		};
	}
	
	/**
	 * A button megnyomásakor történő esemény
	 */
	private Button.ClickListener setButtonEvent()
	{
		return new ClickListener() {
			
			private static final long serialVersionUID = 5710982038485301091L;

			@Override
			public void buttonClick(ClickEvent event) {
				openURL();
			}
		};
	}
	
	
	/**
	 * 
	 */
	private void openURL()
	{
		if(controller.validURL())
			changeLayout();
		else
			showURLLinkError();
	}
	
	private void changeLayout()
	{
		MainLayout main = new MainLayout(controller.getLink());
		this.getUI().setContent(main);
	}
	
	private void showURLLinkError()
	{
		showError("Az URL nem elérhető!", "Biztos hogy ez a cím?");
	}
	
	/**
	 * 
	 * @param msg
	 * @param desc
	 */
	private void showError(String msg,String desc)
	{
		Notification notif = new Notification(msg, desc, Type.WARNING_MESSAGE);
		notif.show(this.getUI().getPage());
	}
	
	
}
