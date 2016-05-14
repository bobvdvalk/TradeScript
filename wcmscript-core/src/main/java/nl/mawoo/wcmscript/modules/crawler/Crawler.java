package nl.mawoo.wcmscript.modules.crawler;

import nl.mawoo.wcmscript.AbstractScriptModule;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * This class is responsible to crawl every website you want.
 *
 * @author Bob van der Valk
 */
public class Crawler extends AbstractScriptModule {

    public Crawler() {
        super();
    }


    /**
     * Run the crawler.
     * The crawler will store it in a ArrayList with CrawlObjects so the user can retrieve them much more easily
     *
     * @return The document
     */
    public Document crawl(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
