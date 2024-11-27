package module13;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrArticleParserTests {
    public static final String HABR_HOST = "https://habr.com/ru/";
    public static final String ARTICLES_PATH = "articles/";

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(HABR_HOST + ARTICLES_PATH).get();
        Elements articles = document.select("article");

        for (Element article : articles) {
            HabrArticleParser habrArticleParser = new HabrArticleParser(article);
            System.out.println(habrArticleParser.getTitle());
            System.out.println(habrArticleParser.getRaring());
        }


    }
}
/*
#\38 61620 > div.tm-article-snippet.tm-article-snippet > h2 > a > span
 */