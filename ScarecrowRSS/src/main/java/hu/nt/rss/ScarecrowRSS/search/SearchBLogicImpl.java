package hu.nt.rss.ScarecrowRSS.search;

import hu.nt.rss.ScarecrowRSS.search.data.Link;

public class SearchBLogicImpl implements SearchBLogic{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5334292819797678099L;
	private Link xml;
	
	/**
	 * 
	 */
	public SearchBLogicImpl() {
		xml = new Link();
	}
	

	@Override
	public Link getLink() {
		return xml;
	}
	
	@Override
	public boolean validURL() {

		String link = xml.getUrl().getValue();
		
		if(link == null)
			return false;
		
		if(link.length()<8)
			return false;
		
		if(link.substring(0, 7).equals("http://") || link.substring(0, 8).equals("https://"))
				return true;
		else
			return false;
	}

	
}
