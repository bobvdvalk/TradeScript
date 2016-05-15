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
