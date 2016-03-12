package nl.mawoo.migratejs.extend.dbconnector;

import nl.mawoo.migratejs.converter.JsonConverter;

import java.sql.*;

/**
 * This class is responsible to connect to a database.
 *
 * @author Bob van der Valk
 */
public class DbConnector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private Connection conn = null;
    private Statement stmt = null;

    //example: mysql:host=localhost;dbname=migratejs_test
    private String connection, username, password;

    /**
     * Set up a database connection with JDBC.
     * @param connection string for your connection
     * @param username user of database
     * @param password password of database
     * @throws ClassNotFoundException
     */
    public DbConnector(String connection, String username, String password) throws ClassNotFoundException {
        this.connection = connection;
        this.username = username;
        this.password = password;

        Class.forName("com.mysql.jdbc.Driver");

        try {
            conn = DriverManager.getConnection(connection, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run a sql query and get results back.
     * @param sql your sql manager
     * @return resultSet of your query
     */
    public String query(String sql) {
        try {
            stmt = conn.createStatement();
            String[] queryType = sql.split(" ");

            if(queryType[0].equals("SELECT")) {
                ResultSet rs = stmt.executeQuery(sql);
                JsonConverter convert = new JsonConverter();
                String jsonData = convert.resultSetConverter(rs);

                rs.close();

                return jsonData;
            } else {
                Boolean query = stmt.execute(sql);
                return "Query is executed";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "There went something wrong. Try again.";
    }
}
