package nl.mawoo.wcmscript.extend.dbconnector;

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
     * Use this function to loop the ResultSet.
     * @return the next row of colums
     *
     * @throws SQLException - when a sql error occurs
     */
    public boolean next() throws SQLException {
        return rs.next();
    }

    /**
     * Return every object from the ResultSet
     * @param columnName name of the column you want to get data from
     * @return object with your data
     *
     * @throws SQLException if a SQL error occurs
     */
    public Object get(String columnName) throws SQLException {
        return rs.getObject(columnName);
    }
    /**
     * Return every object from the ResultSet
     * @param columnName id of the column you want to get data from
     * @return object with your data
     *
     * @throws SQLException if a SQL error occurs
     */
    public Object get(int columnName) throws SQLException {
        return rs.getObject(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName name you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public String getString(String columnName) throws SQLException {
        return rs.getString(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public String getString(int columnName) throws SQLException {
        return rs.getString(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public int getInt(String columnName) throws SQLException {
        return rs.getInt(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public int getInt(int columnName) throws SQLException {
        return rs.getInt(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public Date getDate(String columnName) throws SQLException {
        return rs.getDate(columnName);
    }

    /**
     * Get a String from a ResultSet
     * @param columnName column you want to get information from
     * @return data as a string in the column
     *
     * @throws SQLException If an error occurs in the database
     */
    public Date getDate(int columnName) throws SQLException {
        return rs.getDate(columnName);
    }
}
