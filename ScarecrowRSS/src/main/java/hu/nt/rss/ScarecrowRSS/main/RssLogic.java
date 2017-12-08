package hu.nt.rss.ScarecrowRSS.main;

import java.io.Serializable;

import hu.nt.rss.ScarecrowRSS.main.data.RssChannel;
import hu.nt.rss.ScarecrowRSS.main.parser.XMLParserException;
import hu.nt.rss.ScarecrowRSS.search.data.Link;

public interface RssLogic extends Serializable {

	
	
	/**
	 * 
	 * @param link
	 */
	public void setLink(Link link);
	
	/**
	 * XML letöltése
	 */
	public void loadXML();
	
	
	public void makeRSS()throws XMLParserException;
	/**
	 * 
	 * @return letöltöttm XML szöveges formátumban
	 */
	public String getRawXML();
	
	/**
	 * Letöltött RSS adatok elérhetősége
	 * @return
	 */
	public RssChannel getRSS();
	
}
