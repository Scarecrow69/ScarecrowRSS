package hu.nt.rss.ScarecrowRSS.main.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RssChannel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386490433408250574L;

	private String title = "";
	private String link = "";
	private String description = "";
	private String language = "";
	private String copyright = "";
	private Date pubDate = null;
	private RssImage image = new RssImage();
	
	private List<RssItem> items = new ArrayList<>();

	public RssChannel()
	{
		
	}
	
	public RssChannel(String title, String link, String description, String language, String copyright,
			Date pubDate) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public List<RssItem> getItems() {
		return items;
	}

	public void setItems(List<RssItem> items) {
		this.items = items;
	}
	
	

	public RssImage getImage() {
		return image;
	}

	public void setImage(RssImage image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "RssChannel [title=" + title + ", link=" + link + ", description=" + description + ", language="
				+ language + ", copyright=" + copyright + ", pubDate=" + pubDate + ", items=" + items + "]";
	}
	
	
	
	
}
