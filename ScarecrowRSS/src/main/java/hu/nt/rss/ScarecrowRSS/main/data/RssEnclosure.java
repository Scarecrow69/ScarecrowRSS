package hu.nt.rss.ScarecrowRSS.main.data;

import java.io.Serializable;

public class RssEnclosure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5350735681804460433L;

	private String length, type, url;

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
