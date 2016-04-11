var WebCrawler = function(){
    var crawlerClass = Java.type("nl.mawoo.wcmscript.crawler");
    this.crawler = new crawlerClass();
};

    WebCrawler.prototype.run = function(url) {
        return this.crawler.run(url);
    };