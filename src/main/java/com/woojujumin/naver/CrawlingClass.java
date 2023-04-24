package com.woojujumin.naver;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingClass{
	
	public static Elements moveCrawling() throws Exception{
		
		org.jsoup.nodes.Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
		
		Elements titles = doc.select("div.box-contents strong.title");		
		Elements percents = doc.select("div.box-contents div.score strong.percent span");
		Elements moviedates = doc.select("div.box-contents  span.txt-info strong");
		
		for(int i =0; i<19; i++) {
			Element title = titles.get(i);
			Element percent = percents.get(i);
			Element moviedate = moviedates.get(i);
			
			System.out.println(title.text()+ ":" + percent.text()+ ":"+ moviedate.text());
		}
		return titles;
	}
}
