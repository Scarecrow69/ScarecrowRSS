package hu.nt.rss.ScarecrowRSS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RSSUtils {

	private static RSSUtils util;
	
	
	private RSSUtils()
	{}
	
	
	public static synchronized RSSUtils getInstance()
	{
		if(util == null)
			util = new RSSUtils();
		
		return util;
	}
	
	public String getStringFromInputStream(InputStream is)
	{
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
	
	public Date getDateFromRssString(String s)
	{
		try {
			DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH);
			return formatter.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}
	
	public String getRssStringfromDate(Date d)
	{
		DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH);
		return formatter.format(d);
	}
	
	public String getStringFromDate(Date d)
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(d);
	}
}
