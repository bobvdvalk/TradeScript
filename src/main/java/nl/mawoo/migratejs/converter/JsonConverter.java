package nl.mawoo.migratejs.converter;

import com.google.gson.Gson;
import org.bson.Document;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is responsible to convert objects into JSON
 *
 * @author Bob van der Valk
 */
public class JsonConverter implements Converter<String>{

    @Override
    public String listConverter(List<?> file) {
        return new Gson().toJson(file);
    }

    @Override
    public String resultSetConverter(ResultSet resultSet) throws SQLException {
        ResultSetMetaData md = resultSet.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(50);

        while (resultSet.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),resultSet.getObject(i));
            }
            list.add(row);
        }
        
        return new Gson().toJson(list);
    }

    /**
     * Convert a json object.
     * NOT IMPLEMENTED
     * @param json input you want to convert
     */
    @Override
    public String jsonConverter(String json) {
        return null;
    }

    /**
     * Convert a document
     *
     * @param document input you want to convert
     * @return
     */
    @Override
    public String documentConverter(Document document) {
        return new Gson().toJson(document);
    }
}
