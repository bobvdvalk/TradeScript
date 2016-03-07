package nl.mawoo.migratejs.converter;

import java.util.List;

/**
 * This class is responsible to convert various objects to various types
 * TODO: Implement more methods to convert.
 * @author Bob van der Valk
 */
public interface Converter {
    String listToJson(List<?> list);
}
