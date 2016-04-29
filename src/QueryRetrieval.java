import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class QueryRetrieval {
	
	public void queryRetrieval() throws IOException {
		FileReader in = new FileReader("queriesTest.csv");
		BufferedReader br = new BufferedReader(in);
		String line = null;
		ArrayList<String> URLs = new ArrayList<String>();
		String searchURL = "http://hcc.engr.scu.edu/multilingual-search/PERMIA/search.php?";
		int results = 50;
		while ((line = br.readLine()) != null) {
			String[] input = line.split(",");
			String searchText = input[0];
			String market = input[1];
			String queryURL = searchURL + "searchText=" + searchText + "&source=Web&results=" 
			+ results + "&offset=0&market=" + market;
			URLs.add(queryURL);
		}
		br.close();
		
		ArrayList<ArrayList<String>> db = new ArrayList<ArrayList<String>>();
		int id = 1;
		for (String url: URLs) {
			//System.out.println(url);
			Document doc = Jsoup.connect(url).get();
			Elements hrefs = doc.getElementsByClass("url");
			Elements titles = doc.getElementsByTag("a");
			Elements snippets = doc.getElementsByClass("snippet");
			Elements ranks = doc.getElementsByAttribute("rank");
			for (int i = 0; i < results; i++) {
				ArrayList<String> entry = new ArrayList<String>();
				//System.out.println(id);
				entry.add(Integer.toString(id));
				int end = url.indexOf("&source=Web");
				String query = url.substring(73, end);
				//System.out.println(query);
				entry.add(query);
				int start = url.indexOf("market=");
				String language = url.substring(start + 7);
				//System.out.println(language);
				entry.add(language);
				//System.out.println(hrefs.get(i).text());
				entry.add(hrefs.get(i).text());
				//System.out.println(titles.get(i).text());
				entry.add(titles.get(i).text());
				//System.out.println(snippets.get(i).text());
				entry.add(snippets.get(i).text());
				//System.out.println(ranks.get(i).attr("rank"));
				entry.add(ranks.get(i).attr("rank"));
				Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
				//System.out.println(timestamp.toString());
				entry.add(timestamp.toString());
				db.add(entry);
				id++;
			}
		}	
	}
	
	public static void main(String args[]) throws IOException {
		QueryRetrieval queryRetrieval = new QueryRetrieval();
		queryRetrieval.queryRetrieval();
	}
	
}