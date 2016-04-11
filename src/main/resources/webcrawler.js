var WebCrawler = function(){
    var crawlerClass = Java.type("nl.mawoo.wcmscript.extend.crawler.Crawler");
    this.crawler = new crawlerClass();
};

    WebCrawler.prototype.run = function(url) {
        return this.crawler.run(url);
    };

    WebCrawler.prototype.get = function() {
      return this.crawler.getDocument();
    };