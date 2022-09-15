package step01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static void main(String[] args) {
//		Document doc;
//		try {
//			doc = Jsoup.connect("https://en.wikipedia.org/").get();
//		
//		System.out.println((doc.title()));
//		Elements newsHeadlines = doc.select("#mp-itn b a");
//		for (Element headline : newsHeadlines) {
//		  System.out.println(("%s\n\t%s"+ 
//		    headline.attr("title") + headline.absUrl("href")));
//		}
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		Document doc2;
//		try {
//			doc2 = Jsoup.connect("https://ko.wikipedia.org/").get();
//		
//		System.out.println((doc2.title()));
//		Elements newsHeadlines = doc2.select(".wikipedia-ko.news.main-box ul li a");
//		for (Element headline : newsHeadlines) {
//		  System.out.println(("%s\n\t%s"+ 
//		    headline.attr("title") + headline.absUrl("href")));
//		}
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
		
		Document doc3;
		try {
			doc3 = Jsoup.connect("https://www.w3schools.com/js/").get();
		
//		System.out.println((doc3.title()));
		Elements newsHeadlines = doc3.select("#main h1 ,#main h2"); 
		
		for (Element headline : newsHeadlines) {
//		  System.out.println(("%s\n\t%s"+ 
//		    headline.attr("title") + headline.absUrl("href")));
			System.out.println(headline.text());
		}
		}
		catch (IOException e) {
			e.printStackTrace();
	
	}

	}
	
	}


