package nl.mawoo.wcmscript.extend.dbconnector;

import nl.mawoo.wcmscript.logger.AbstractLogger;
import nl.mawoo.wcmscript.logger.WCMSLogger;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * This class is responsible to connect to a database.
 *
 * @author Bob van der Valk
 */
public class DbConnector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private AbstractLogger logger = WCMSLogger.getLogger(DbConnector.class);

    private Connection conn = null;
    private Statement stmt = null;


    /**
     * Set up a database connection with JDBC.
     * @param connection string for your connection
     * @param username user of database
     * @param password password of database
     * @throws ClassNotFoundException
     */
    public DbConnector(String connection, String username, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try {
            conn = DriverManager.getConnection(connection, username, password);
        } catch (SQLException e) {
            logger.error("Cannot connect to database: "+ e);
        }
    }

    /**
     * Run a sql query and get results back.
     * @param sql your sql manager
     * @return resultSet of your query
     */
    public ResultSetObject query(String sql) {
        try {
            stmt = conn.createStatement();
            String[] queryType = sql.split(" ");

            if("SELECT".equals(queryType[0])) {
                ResultSet rs = stmt.executeQuery(sql);

                return new ResultSetObject(rs);
            } else {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            logger.error("A SQL exception occurred: "+ e);
        }

        return null;
    }
}
