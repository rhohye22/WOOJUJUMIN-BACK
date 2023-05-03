package com.woojujumin.naver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CrawlingClass {

	private static HashMap<String, Object> movieData = null;

	public static HashMap<String, Object> cgvmovieCrawling() throws Exception {

		if (movieData == null) {
			// cgv - 현재 상영작
			Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=1").get();

			Elements titles = doc.select("div.box-contents strong.title");
			Elements percents = doc.select("div.box-contents div.score strong.percent span");
			Elements moviedates = doc.select("div.box-contents  span.txt-info strong");
			Elements posters = doc.select("div.box-image span.thumb-image img");

//		HashMap<String, Object> map = new HashMap<>();
			List<String> movie = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/finalProject/WOOJUJUMIN-FRONT/src/components/crawlingimages"; // 로컬 파일 경로 설정

			for (int i = 0; i < 15; i++) {
				Element title = titles.get(i);
				Element percent = percents.get(i);
				Element moviedate = moviedates.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text()+ ":" + percent.text()+ ":"+ moviedate.text());

				String imageUrl = poster.attr("src");
				String localImagePath = ImageDownloader.downloadImage(imageUrl, downloadDir);
				movie.add(title.text() + ":" + percent.text() + ":" + moviedate.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			movieData = new HashMap<>();
			movieData.put("movie", movie);
			movieData.put("images", images);
		}

		return movieData;

	}

	private static HashMap<String, Object> bookData = null;

	public static HashMap<String, Object> aladinCrawling() throws Exception {

		if (bookData == null) {
			// 알라딘 베스트 순위
//			String url = "http://www.yes24.com/24/Category/BestSeller?CategoryNumber=001&sumgb=06";
//			Document doc = Jsoup.connect(url).get();
//
//			Elements titles = doc.select("table#category_layout td.goodsTxtInfo p a");
//			Elements details = doc.select("table#category_layout p.read");
//			Elements bookdatas = doc.select("table#category_layout div.aupu");
//			Elements posters = doc.select("table#category_layout div.goodsImgW img");

			String url = "https://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1&start=we";
			Document doc = Jsoup.connect(url).get();

			Elements titles = doc.select("div.ss_book_box div.ss_book_list ul li a.bo3 b");
			Elements datas = doc.select("div.ss_book_box td div.ss_book_list:first-child ul li:nth-child(3)");
			Elements posters = doc
					.select("div.flipcover_out div.flipcover_in img.front_cover, div.cover_area_other img.i_cover");

//			Elements ul = doc.select("div.ss_book_list ul li span.ss_ht1 a");
			
			Elements ul = doc.select("div.ss_book_list:first-child ul");
			int liCount = ul.first().select("li").size();		
//			System.out.println(liCount);

			List<String> sendtitles = new ArrayList<>();
			List<String> senddatas = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/finalProject/WOOJUJUMIN-FRONT/src/components/crawlingimages"; // 로컬 파일 경로 설정

			for (int i = 0; i < 50; i++) {
//				Element ull = ul.get(i);
//				System.out.println(ull);

//				Element ull;
//			    try {
//			        ull = ul.get(i);
//			    } catch (IndexOutOfBoundsException e) {
//			        datas = doc.select("div.ss_book_box td div.ss_book_list:first-child ul li:nth-child(2)");
//			    }
//				try {
//					if(ul.get(i) != null ) {
//						datas = doc.select("div.ss_book_box td div.ss_book_list:first-child ul li:nth-child(3)");
//					}else {
//						datas = doc.select("div.ss_book_box td div.ss_book_list:first-child ul li:nth-child(2)");
//					}
//				}
//				catch (IndexOutOfBoundsException e){
//					datas = doc.select("div.ss_book_box td div.ss_book_list:first-child ul li:nth-child(3)");
//				}
						
				Element title = titles.get(i);
				Element data = datas.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text());

				String imageUrl = poster.attr("src");
				if (imageUrl.startsWith("//")) {
					imageUrl = "http:" + imageUrl;
				}
				String localImagePath = ImageDownloader.downloadImage(imageUrl, downloadDir);
//				System.out.println(title.text());
				sendtitles.add(title.text());
				senddatas.add(data.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			bookData = new HashMap<>();
			bookData.put("sendtitles", sendtitles);
			bookData.put("senddatas", senddatas);
			bookData.put("images", images);
		}

		return bookData;

	}

	private static HashMap<String, Object> localeventpageone = null;

	public static HashMap<String, Object> localOneCrawling() throws Exception {

		if (localeventpageone == null) {

			// 문화체육관광부
			String url = "https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp?pMenuCD=&pCurrentPage=1&pSearchType=&pSearchWord=&pSeq=&pSido=&pOrder=&pPeriod=&fromDt=&toDt=";
			Document doc = Jsoup.connect(url).get();

			Elements titles = doc.select("ul.mediaWrap div.text p.title");
			Elements informations = doc.select("ul.mediaWrap div.text div.ny");
			Elements details = doc.select("ul.mediaWrap div.text ul.detail_info");
			Elements posters = doc.select("ul.mediaWrap div.img img");

//			System.out.println(titles);

			List<String> sendtitles = new ArrayList<>();
			List<String> sendinformations = new ArrayList<>();
			List<String> senddates = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/finalProject/WOOJUJUMIN-FRONT/src/components/crawlingimages"; // 로컬 파일 경로 설정

			for (int i = 0; i < 5; i++) {
				Element title = titles.get(i);
				Element information = informations.get(i);
				Element detail = details.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text());

				String addurl = "https://www.mcst.go.kr";
				String imageUrl = poster.attr("src");
				String localImagePath = ImageDownloader.downloadImage(addurl + imageUrl, downloadDir);
//				System.out.println(title.text());

				sendtitles.add(title.text());
				sendinformations.add(information.text());
				senddates.add(detail.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			localeventpageone = new HashMap<>();
			localeventpageone.put("sendtitles", sendtitles);
			localeventpageone.put("sendinformations", sendinformations);
			localeventpageone.put("senddates", senddates);
			localeventpageone.put("images", images);
		}

		return localeventpageone;

	}

	private static HashMap<String, Object> localeventpagetwo = null;

	public static HashMap<String, Object> localTwoCrawling() throws Exception {

		if (localeventpagetwo == null) {

			// 문화체육관광부
			String url = "https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp?pMenuCD=&pCurrentPage=2&pSearchType=&pSearchWord=&pSeq=&pSido=&pOrder=&pPeriod=&fromDt=&toDt=";
			Document doc = Jsoup.connect(url).get();

			Elements titles = doc.select("ul.mediaWrap div.text p.title");
			Elements informations = doc.select("ul.mediaWrap div.text div.ny");
			Elements details = doc.select("ul.mediaWrap div.text ul.detail_info");
			Elements posters = doc.select("ul.mediaWrap div.img img");

//			System.out.println(titles);

			List<String> sendtitles = new ArrayList<>();
			List<String> sendinformations = new ArrayList<>();
			List<String> senddates = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/finalProject/WOOJUJUMIN-FRONT/src/components/crawlingimages"; // 로컬 파일 경로 설정

			for (int i = 0; i < 5; i++) {
				Element title = titles.get(i);
				Element information = informations.get(i);
				Element detail = details.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text());

				String addurl = "https://www.mcst.go.kr";
				String imageUrl = poster.attr("src");
				String localImagePath = ImageDownloader.downloadImage(addurl + imageUrl, downloadDir);
//				System.out.println(title.text());

				sendtitles.add(title.text());
				sendinformations.add(information.text());
				senddates.add(detail.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			localeventpagetwo = new HashMap<>();
			localeventpagetwo.put("sendtitles", sendtitles);
			localeventpagetwo.put("sendinformations", sendinformations);
			localeventpagetwo.put("senddates", senddates);
			localeventpagetwo.put("images", images);
		}

		return localeventpagetwo;

	}

	private static HashMap<String, Object> localeventpagethree = null;

	public static HashMap<String, Object> localThreeCrawling() throws Exception {

		if (localeventpagethree == null) {

			// 문화체육관광부
			String url = "https://www.mcst.go.kr/kor/s_culture/festival/festivalList.jsp?pMenuCD=&pCurrentPage=3&pSearchType=&pSearchWord=&pSeq=&pSido=&pOrder=&pPeriod=&fromDt=&toDt=";
			Document doc = Jsoup.connect(url).get();

			Elements titles = doc.select("ul.mediaWrap div.text p.title");
			Elements informations = doc.select("ul.mediaWrap div.text div.ny");
			Elements details = doc.select("ul.mediaWrap div.text ul.detail_info");
			Elements posters = doc.select("ul.mediaWrap div.img img");

//			System.out.println(titles);

			List<String> sendtitles = new ArrayList<>();
			List<String> sendinformations = new ArrayList<>();
			List<String> senddates = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/finalProject/WOOJUJUMIN-FRONT/src/components/crawlingimages"; // 로컬 파일 경로 설정

			for (int i = 0; i < 5; i++) {
				Element title = titles.get(i);
				Element information = informations.get(i);
				Element detail = details.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text());

				String addurl = "https://www.mcst.go.kr";
				String imageUrl = poster.attr("src");
				System.out.println(imageUrl);
				String localImagePath = ImageDownloader.downloadImage(addurl + imageUrl, downloadDir);
//				System.out.println(title.text());

				sendtitles.add(title.text());
				sendinformations.add(information.text());
				senddates.add(detail.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			localeventpagethree = new HashMap<>();
			localeventpagethree.put("sendtitles", sendtitles);
			localeventpagethree.put("sendinformations", sendinformations);
			localeventpagethree.put("senddates", senddates);
			localeventpagethree.put("images", images);
		}

		return localeventpagethree;

	}

	private static HashMap<String, Object> musicData = null;

	public static HashMap<String, Object> musicCrawling() throws Exception {

		if (musicData == null) {

			// 멜론이다으아아
			String url = "https://www.melon.com/chart/index.htm";
			Document doc = Jsoup.connect(url).get();

			Elements titles = doc.select("tr.lst50 td div.wrap div.wrap_song_info div.rank01 a");
			Elements singers = doc.select("tr.lst50 td div.wrap div.wrap_song_info div.rank02 span.checkEllipsis a");
			Elements albums = doc.select("tr.lst50 td div.wrap div.rank03 a");
			Elements posters = doc.select("tr.lst50 td div.wrap a img");

//			System.out.println(titles);

			List<String> sendtitles = new ArrayList<>();
			List<String> sendsingers = new ArrayList<>();
			List<String> sendalbums = new ArrayList<>();
			List<String> images = new ArrayList<>();

			String downloadDir = "/woojujumin/WOOJUJUMIN-FRONT/src/components/crawlingimages/musicimages"; // 로컬 파일 경로

			for (int i = 0; i < 50; i++) {
				Element title = titles.get(i);
				Element singer = singers.get(i);
				Element album = albums.get(i);
				Element poster = posters.get(i);

//			System.out.println(title.text());

				String imageUrl = poster.attr("src");
//				System.out.println(imageUrl);
				String localImagePath = ImageDownloader.downloadImage(imageUrl, downloadDir);
//				System.out.println(title.text());

				sendtitles.add(title.text());
				sendsingers.add(singer.text());
				sendalbums.add(album.text());
				images.add(localImagePath);

//			System.out.println(poster);

			}

			musicData = new HashMap<>();
			musicData.put("sendtitles", sendtitles);
			musicData.put("sendsingers", sendsingers);
			musicData.put("sendalbums", sendalbums);
			musicData.put("images", images);
		}

		return musicData;

	}

	// 이미지 경로에 저장하는 함수
	public class ImageDownloader {
		public static String downloadImage(String imageUrl, String downloadDir) throws IOException {
			URL url = new URL(imageUrl);
			BufferedInputStream inputStream = new BufferedInputStream(url.openStream());

			Path dirPath = Paths.get(downloadDir);
			if (!Files.exists(dirPath)) {
				Files.createDirectories(dirPath);
			}

			String fileName = "image_" + System.currentTimeMillis() + ".jpg";
			Path filePath = Paths.get(downloadDir, fileName);
			FileOutputStream outputStream = new FileOutputStream(filePath.toFile());

			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outputStream.close();

			return filePath.toString();
		}
	}
}
