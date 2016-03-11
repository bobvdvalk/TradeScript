package nl.mawoo.migratejs.converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is responsible to convert various objects to various types
 * TODO: Implement more methods to convert.
 * @author Bob van der Valk
 */
public interface Converter {
    /**
     * Convert a list<>
     * @param list list of items
     */
    String listConverter(List<?> list);

    /**
     * Convert a ResultSet
     * @param resultSet your ResultSet you want to use
     */
    String resultSetConverter(ResultSet resultSet) throws SQLException;
}
