/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
