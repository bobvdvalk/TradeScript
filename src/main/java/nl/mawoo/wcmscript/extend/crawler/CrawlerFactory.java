package nl.mawoo.wcmscript.extend.crawler;

import org.jsoup.nodes.Document;

/**
 * This class creates a crawler class
 *
 * @author Bob van der Valk
 */
public class CrawlerFactory {

    private Crawler crawler;

    private CrawlerFactory() {

    }

    public void run(String url) {
        crawler = new Crawler();
        crawler.run(url);
    }

    public Document get() {
        return crawler.getDocument();
    }

}
