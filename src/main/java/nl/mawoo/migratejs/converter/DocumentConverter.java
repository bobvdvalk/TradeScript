package nl.mawoo.migratejs.converter;

import org.bson.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible to convert certain types to documents
 *
 * list & resultSet converter methods are not implemented yet.
 *
 * @author Bob van der Valk
 */
public class DocumentConverter implements Converter<Document> {
    /**
     * Convert a list<>
     * NOT IMPLEMENTED
     * @param list list of items
     */
    @Override
    public Document listConverter(List<?> list) {
        return null;
    }

    /**
     * Convert a ResultSet
     * NOT IMPLEMENTED
     * @param resultSet your ResultSet you want to use
     */
    @Override
    public Document resultSetConverter(ResultSet resultSet) throws SQLException {
        return null;
    }

    /**
     * Convert a json object.
     *
     * @param json input you want to convert
     */
    @Override
    public Document jsonConverter(String json) {
        return null;
    }
}
