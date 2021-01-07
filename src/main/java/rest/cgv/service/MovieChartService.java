package rest.cgv.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import rest.cgv.vo.MovieChart;

@Service
public class MovieChartService {

	public List<MovieChart> getMoviceChart() throws IOException{
		List<MovieChart> mcList = new ArrayList();
		String url = "http://www.cgv.co.kr/movies/";
		Connection conn = Jsoup.connect(url);
		Document html = conn.get();
		Elements divMovieChart = html.getElementsByClass("sect-movie-chart");
		Elements imgs = divMovieChart.get(0).getElementsByTag("img");
		for ( int i = 0 ; i < imgs.size() ; i++ ) {
			String src = imgs.get(i).attr("src");
			if (!src.contains("/ad")) {
				MovieChart mc = new MovieChart();
				mc.setSrc(imgs.get(i).attr("src"));
				mcList.add(mc);
			}
		}
		return mcList;
	}
}
