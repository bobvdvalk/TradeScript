package nl.mawoo.migratejs.extend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class is responsible for web requests
 */
public class WebRequest {

    private final String USER_AGENT = "Mozilla/5.0";
    private int responseCode;



    /**
     * Execute a get request and the data will return as String
     * @param request url request you want data from
     * @return Content of the request
     */
    public String getRequestAsString(String request) throws IOException {
        URL obj = new URL(request);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }



    /**
     * @return response code of the current request.
     */
    public int getResponseCode() {
        return responseCode;
    }
}
