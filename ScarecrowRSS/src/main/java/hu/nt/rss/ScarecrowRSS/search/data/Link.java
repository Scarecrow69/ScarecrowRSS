package hu.nt.rss.ScarecrowRSS.search.data;

import java.io.Serializable;

import com.vaadin.data.util.ObjectProperty;

public class Link implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5481791000242698201L;

	private ObjectProperty<String> url;
	
	public Link(ObjectProperty<String> url) {
		super();
		this.url = url;
	}
	
	public Link()
	{
		this.url = new ObjectProperty<String>("",String.class);
	}

	public ObjectProperty<String> getUrl() {
		return url;
	}

	public void setUrl(ObjectProperty<String> url) {
		this.url = url;
	}
	
	
}
