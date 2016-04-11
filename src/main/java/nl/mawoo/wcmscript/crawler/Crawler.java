package nl.mawoo.wcmscript.crawler;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible to crawl every website you want
 *
 * @author Bob van der Valk
 */
public class Crawler {
    private Logger logger = Logger.getLogger(Crawler.class.getName());
    private String element;
    private ArrayList<Document> arrayList;

    public Crawler(String element) {
        this.element = element;
    }

    /**
     * Run the crawler.
     * The crawler will store it in a ArrayList with CrawlObjects so the user can retrieve them much more easily
     *
     * @return ArrayList with CrawlObjects
     */
    public void run(String url) {
        Document document = null;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("Can\'t get contents of "+ url +": "+ e);
        }

        //TODO: add to arraylist

        Elements questions = document.select("a[href]");
        for(Element link: questions){
            if(link.attr("href").contains("mit.edu"))
                this.run(link.attr("abs:href"));
        }
    }


}
