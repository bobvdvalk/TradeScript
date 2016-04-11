package nl.mawoo.wcmscript.extend.crawler;

import org.jsoup.nodes.Document;

/**
 * This object is responsible to save any crawl data
 *
 * @author Bob van der Valk
 */
public class CrawlObject {
    private String url;
    private String head;
    private String title;
    private String body;
    private Document document;

    public CrawlObject(String url, String head, String title, String body) {
        this.url = url;
        this.head = head;
        this.title = title;
        this.body = body;
    }

    public CrawlObject(Document document) {
        this.document = document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
