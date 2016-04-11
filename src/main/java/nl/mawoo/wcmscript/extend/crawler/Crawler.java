package nl.mawoo.wcmscript.extend.crawler;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * This class is responsible to crawl every website you want
 *
 * @author Bob van der Valk
 */
public class Crawler {
    private Logger logger = Logger.getLogger(Crawler.class.getName());
    private Document document;

    /**
     * Run the crawler.
     * The crawler will store it in a ArrayList with CrawlObjects so the user can retrieve them much more easily
     *
     * @return ArrayList with CrawlObjects
     */
    public void run(String url) {
        document = null;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("Can\'t get contents of "+ url +": "+ e);
        }
    }

    /**
     * Get the current document
     * @return craweld website.
     */
    public Document getDocument() {
        return document;
    }
}
