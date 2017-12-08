package hu.nt.rss.ScarecrowRSS.main.data;

public interface RssElement {

	public static final String DESCRIPTION = "description";
	public static final String LINK = "link";
	public static final String TITLE = "title";
	public static final String PUBDATE = "pubDate";
	
	public static final String IMAGE="image";
	
	
	
	public interface Channel {
		
		
		public static final String CHANNEL = "channel";
		public static final String LANGUAGE = "language";
		public static final String COPYRIGHT = "copyright";
		
	}

	public interface Item {
		public static final String ITEM = "item";
		public static final String GUID = "guid";
		public static final String AUTHOR = "author";
		
	}

}
