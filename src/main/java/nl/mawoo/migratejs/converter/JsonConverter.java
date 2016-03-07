package nl.mawoo.migratejs.converter;

import com.google.gson.Gson;

import java.util.List;

/**
 * This class is responsible to convert objects to JSON
 *
 * @author Bob van der Valk
 */
public class JsonConverter implements Converter{

    @Override
    public String listToJson(List<?> file) {
        return new Gson().toJson(file);
    }
}
