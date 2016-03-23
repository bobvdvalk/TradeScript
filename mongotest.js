use("mongodb.js");

print("start");

var Mongo = new MongoDBConnect("local");
//var document = document("{title: 'MongoDB Overview',description: 'MongoDB is no sql database',by: 'tutorials point',url: 'http://www.tutorialspoint.com',tags: ['mongodb', 'database', 'NoSQL'], likes: 100}");
var input = document("{}");

print(Mongo.getCollection("Test_collection").find(input));

print("done");