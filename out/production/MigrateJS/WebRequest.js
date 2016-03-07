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
