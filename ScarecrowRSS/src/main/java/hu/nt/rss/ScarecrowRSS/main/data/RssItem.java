package hu.nt.rss.ScarecrowRSS.main.data;

import java.io.Serializable;
import java.util.Date;

public class RssItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2726030217781158694L;

	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;
	private Date pubDate;
	
	public RssItem(){}
	
	
	public RssItem(String title, String description, String link, String author, String guid, Date pubDate) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
		this.author = author;
		this.guid = guid;
		this.pubDate = pubDate;
	}



	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	@Override
	public String toString() {
		return "RssItem [title=" + title + ", description=" + description + ", link=" + link + ", author=" + author
				+ ", guid=" + guid + ", pubDate=" + pubDate + "]";
	}
	
	

}
