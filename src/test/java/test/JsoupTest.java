package test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static void main(String[] args) throws IOException {

		String url = "https://www.coupang.com/";

		Connection conn = Jsoup.connect(url);

		Document html = conn.get();

//		System.out.println(html.toString());

		Elements menuList = html.getElementsByClass("shopping-menu-list");

//		System.out.println(menuList.toString());
//		System.out.println("*"+menuList.get(0).childNodes().size());
//		Element ele = menuList.get(0);
//		System.out.println(ele);
		
		for (int i = 0; i < menuList.get(0).childNodes().size(); i++) {
			if(i%2==0)
			System.out.println(menuList.get(0).childNode(i).childNode(0).childNode(0));
		}


	}

}
