package nl.mawoo.migratejs.converter;

import org.bson.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * /**
 * This class is responsible to convert various objects to various types
 * TODO: Find a better and cleaner way to do this.
 * @param <Type> object type for the implementation
 * @author Bob van der Valk
 */
public interface Converter<Type> {
    /**
     * Convert a list<>
     * @param list list of items
     */
    Type listConverter(List<?> list);

    /**
     * Convert a ResultSet
     * @param resultSet your ResultSet you want to use
     */
    Type resultSetConverter(ResultSet resultSet) throws SQLException;

    /**
     * Convert a json object.
     * @param json input you want to convert
     */
    Type jsonConverter(String json);

    /**
     * Convert a document
     * @param document input you want to convert
     * @return
     */
    Type documentConverter(Document document);
}
