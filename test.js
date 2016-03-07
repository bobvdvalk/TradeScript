use("WebRequest.js");

var url = "https://btc-e.com/api/3/ticker/btc_usd";
var get = WebRequest.getRequest(url);

print("Get result: "+ get);

var post = WebRequest.postRequest("https://www.calcatraz.com/calculator/api?", "c=3%2A3");

print("POST result: "+ post);


