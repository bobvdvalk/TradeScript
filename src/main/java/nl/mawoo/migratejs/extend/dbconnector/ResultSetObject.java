package nl.mawoo.migratejs.extend.dbconnector;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is responsible to return data from a result set in MySql
 *
 * @author Bob van der Valk
 */
public class ResultSetObject {
    private ResultSet rs;

    /**
     * Set the ResultSet to get easily information from the database
     * @param rs Resultset to get information from
     */
    public ResultSetObject(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     * @throws SQLException If an error occurs in the database
     */
    public String getString(String columnName) throws SQLException {
        return rs.getString(columnName);
    }
    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     * @throws SQLException If an error occurs in the database
     */
    public int getInt(String columnName) throws SQLException {
        return rs.getInt(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     * @throws SQLException If an error occurs in the database
     */
    public Date getDate(String columnName) throws SQLException {
        return rs.getDate(columnName);
    }
}
