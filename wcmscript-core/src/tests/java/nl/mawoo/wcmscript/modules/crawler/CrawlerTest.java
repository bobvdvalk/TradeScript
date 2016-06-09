package nl.mawoo.wcmscript.modules.crawler;

import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

/**
 * This class tests the Crawler implementation
 *
 * @author Bob van der Valk
 */
public class CrawlerTest {
    /**
     * Message before the test starts
     */
    @BeforeClass
    public static void oneTimeSetup() {
        System.out.println("initialization crawler test");
    }

    /**
     * Test the crawler class
     * TODO: finish it
     * @throws IOException
     */
    @Test
    public void getTitle() throws IOException {
        Crawler crawler = new Crawler();
        Document output = crawler.crawl("http://mawoo.nl");

        assertEquals("Home | Mawoo Nederland", output.title());
    }

    /**
     * Message after the test is completed
     */
    @AfterClass
    public static void testDone() {
        System.out.println("Crawler test is done.");
    }
}
