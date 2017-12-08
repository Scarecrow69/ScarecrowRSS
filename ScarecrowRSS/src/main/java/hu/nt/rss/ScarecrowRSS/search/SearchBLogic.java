package hu.nt.rss.ScarecrowRSS.search;

import java.io.Serializable;

import hu.nt.rss.ScarecrowRSS.search.data.Link;

public interface SearchBLogic extends Serializable{
	/**
	 * url mögött lévő RSS ellenőrzése
	 * @return
	 */
	public boolean validURL(); 
	
		
	public Link getLink();
	
}
