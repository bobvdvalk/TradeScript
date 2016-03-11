package nl.mawoo.migratejs.converter;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible to convert objects into JSON
 *
 * @author Bob van der Valk
 */
public class JsonConverter implements Converter{

    @Override
    public String listConverter(List<?> file) {
        return new Gson().toJson(file);
    }

    @Override
    public String resultSetConverter(ResultSet resultSet) throws SQLException {
        JSONArray json = new JSONArray();
        ResultSetMetaData resultSetmd = resultSet.getMetaData();
        int numColumns = resultSetmd.getColumnCount();
        while (resultSet.next()) {

            JSONObject obj = new JSONObject();

            for (int i = 1; i < numColumns + 1; i++) {
                String column_name = resultSetmd.getColumnName(i);

                if (resultSetmd.getColumnType(i) == java.sql.Types.ARRAY) {
                    obj.put(column_name, resultSet.getArray(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.BIGINT) {
                    obj.put(column_name, resultSet.getLong(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.REAL) {
                    obj.put(column_name, resultSet.getFloat(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
                    obj.put(column_name, resultSet.getBoolean(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.BLOB) {
                    obj.put(column_name, resultSet.getBlob(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.DOUBLE) {
                    obj.put(column_name, resultSet.getDouble(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.FLOAT) {
                    obj.put(column_name, resultSet.getDouble(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.INTEGER) {
                    obj.put(column_name, resultSet.getInt(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
                    obj.put(column_name, resultSet.getNString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.VARCHAR) {
                    obj.put(column_name, resultSet.getString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.CHAR) {
                    obj.put(column_name, resultSet.getString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.NCHAR) {
                    obj.put(column_name, resultSet.getNString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.LONGNVARCHAR) {
                    obj.put(column_name, resultSet.getNString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.LONGVARCHAR) {
                    obj.put(column_name, resultSet.getString(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.TINYINT) {
                    obj.put(column_name, resultSet.getByte(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.SMALLINT) {
                    obj.put(column_name, resultSet.getShort(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.DATE) {
                    obj.put(column_name, resultSet.getDate(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.TIME) {
                    obj.put(column_name, resultSet.getTime(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
                    obj.put(column_name, resultSet.getTimestamp(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.BINARY) {
                    obj.put(column_name, resultSet.getBytes(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.VARBINARY) {
                    obj.put(column_name, resultSet.getBytes(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.LONGVARBINARY) {
                    obj.put(column_name, resultSet.getBinaryStream(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.BIT) {
                    obj.put(column_name, resultSet.getBoolean(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.CLOB) {
                    obj.put(column_name, resultSet.getClob(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.NUMERIC) {
                    obj.put(column_name, resultSet.getBigDecimal(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.DECIMAL) {
                    obj.put(column_name, resultSet.getBigDecimal(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.DATALINK) {
                    obj.put(column_name, resultSet.getURL(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.REF) {
                    obj.put(column_name, resultSet.getRef(column_name));
                } else if (resultSetmd.getColumnType(i) == java.sql.Types.JAVA_OBJECT) {
                    obj.put(column_name, resultSet.getObject(column_name));
                } else {
                    obj.put(column_name, resultSet.getString(i));
                }
            }

            json.put(obj);
        }

        return new Gson().toJson(json);
    }



}
