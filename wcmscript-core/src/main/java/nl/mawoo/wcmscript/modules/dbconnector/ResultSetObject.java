/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.mawoo.wcmscript.modules.dbconnector;

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