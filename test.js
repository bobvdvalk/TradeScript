use("dbconnector.js");

var connString = "jdbc:mysql://localhost/migratejs_test";

var dbConnector = new DbConnector(connString, "root", "");

var sql = "SELECT * FROM person";
var data = dbConnector.query(sql);

print(data);