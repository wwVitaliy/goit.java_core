package module13.habrcarticleparser;

import org.jsoup.nodes.Element;

public class HabrArticleParser {

    private Element article;

    public HabrArticleParser(Element article) {
        this.article = article;
    }

    public String getTitle() {
        return article.select("a.tm-title__link")
                .first()
                .text();
    }

    public String getRaring() {
        return article.select("span.tm-votes-meter__value").first().text();
    }

}
