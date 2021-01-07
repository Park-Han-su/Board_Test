package test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CgvMovieChart {

	public static void main(String[] args) throws IOException {
		
		String url = "http://www.cgv.co.kr/movies/";

		Connection conn = Jsoup.connect(url);

		Document html = conn.get();
		
		Elements divMovieChart = html.getElementsByClass("sect-movie-chart");
		
		Elements imgs = divMovieChart.get(0).getElementsByTag("img");
		
		for ( int i = 0 ; i < imgs.size() ; i++ ) {
			String src = imgs.get(i).attr("src");
			if (!src.contains("/ad")) {
				System.out.println(imgs.get(i).attr("src"));
			}
		}
		
	}

}
