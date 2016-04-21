package nl.mawoo.wcmscript.extend.crawler;

import org.jsoup.nodes.Document;

/**
 * Crawler interface
 * Crawl html files/pages
 *
 * @author Bob van der Valk
 */
public interface Crawler {
    /**
     * Run a url request
     * @param url
     */
    void run(String url);

    /**
     * Return the current Document that is imported
     * @return Selected content from page
     */
    Document get();
}
