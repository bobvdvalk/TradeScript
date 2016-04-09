var Request = {
    /**
     * Send a GET request to a url.
     * View documentation at: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
     * @param request
     * @returns {*}
     * @constructor
     */
    Get: function(request) {
        var req = Java.type("nl.mawoo.wcmscript.extend.webrequest.WebRequest");
        return req.Get(request);
    },
    /**
     * Send a POST request to a url.
     * View documentation at: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
     * @param request
     * @returns {*}
     * @constructor
     */
    Post: function(request) {
        var req = Java.type("nl.mawoo.wcmscript.extend.webrequest.WebRequest");
        return req.Post(request);
    }
};
