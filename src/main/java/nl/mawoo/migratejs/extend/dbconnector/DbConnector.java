package nl.mawoo.migratejs.extend.dbconnector;

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
     * Set up the connection.
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
    public ResultSet query(String sql) {
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
