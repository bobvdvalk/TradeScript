webRequest = {
  getRequest: function(request) {
      var webRequestClass = Java.type("nl.mawoo.migratejs.extend.WebRequest");
      var webRequest = new webRequestClass();

      return webRequest.getRequestAsString(request);
  },
  sayHello: function() {
      print("Hey, how are you?");
  }
};
