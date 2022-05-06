import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class WebSite {
    public static final String WEB = "https://www.sport5.co.il/", URL = "https://";

    public static void web() {
        try {
            Document web = Jsoup.connect(WEB).get();
//            String webTitle = web.title();
//            System.out.println(webTitle);

            Element titleBar = web.getElementById("header").getElementById("nav");
            Element globalFootball = titleBar.child(1).child(1);
            String globalFootballLink = globalFootball.getElementsByTag("a").attr("href");

            Document globalFootballPage = Jsoup.connect(globalFootballLink).get();
            System.out.println(globalFootballPage.title());

            ArrayList<Element> allLigot = globalFootballPage.getElementsByClass("add-nav-liga");
            Element liga = allLigot.get(0).child(0).child(6); // liga
            System.out.println(liga);

            String linkLiga = liga.child(0).attr("href");
            Document ligaPage =Jsoup.connect(linkLiga).get();

            ArrayList<Element> allTable = ligaPage.getElementsByClass("score-list");
            ArrayList<Element> a = allTable.get(0).getElementsByTag("table");
            System.out.println(a.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
