WebRequest = {

    /**
     * This method is responsible for the get web request.
     * @param request url you want to reach
     * @returns string with content of the request.
     */
    getRequest: function(request) {
      var webRequestClass = Java.type("nl.mawoo.migratejs.extend.webrequest.WebRequest");
      var webRequest = new webRequestClass(request);

      return webRequest.getRequestAsString();
    },

    postRequest: function(request, parameters) {
        var webRequestClass = Java.type("nl.mawoo.migratejs.extend.webrequest.WebRequest");
        var webRequest = new webRequestClass(request);

        return webRequest.postRequestAsString(parameters);
    }
};

Request = {
    /**
     * Send a GET request to a url.
     * View documentation at: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
     * @param request
     * @returns {*}
     * @constructor
     */
    Get: function(request) {
        var req = Java.type("nl.mawoo.migratejs.extend.webrequest.WebRequest");
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
        var req = Java.type("nl.mawoo.migratejs.extend.webrequest.WebRequest");
        return req.Post(request);
    }

};
