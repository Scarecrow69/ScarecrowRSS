package hu.nt.rss.ScarecrowRSS.main.data;

import java.io.Serializable;

public class RssImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7801061994950255617L;

	private String description, height, link, title, url, width;

	public RssImage(){}
	
	
	public String getDescription() {
		return description;
	}

	public RssImage(String description, String height, String link, String title, String url, String width) {
		super();
		this.description = description;
		this.height = height;
		this.link = link;
		this.title = title;
		this.url = url;
		this.width = width;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	
	
}
