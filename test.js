use("WebRequest.js");

var url = "https://btc-e.com/api/3/ticker/btc_usd";
var get = WebRequest.getRequest(url);

print("Result: "+ get);