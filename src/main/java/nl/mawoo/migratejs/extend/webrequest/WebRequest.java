package nl.mawoo.migratejs.extend.webrequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class is responsible for web requests
 *
 * @author Bob van der Valk
 */
public class WebRequest {

    private final String USER_AGENT = "Mozilla/5.0";
    private int responseCode;

    private String request;
    private URL obj;
    private HttpURLConnection con;

    /**
     * Instance a new web request.
     * @param request string of url
     */
    public WebRequest(String request) {
        this.request = request;

        try {
            this.obj = new URL(this.request);
            con = (HttpURLConnection) this.obj.openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute a get request and the data will return as String
     * @return Content of the request
     */
    public String getRequestAsString() throws IOException {

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }

    /**
     * Place a post web request.
     * @param parameterString parameters you want to give to the request
     * @return String of the content returned from the request
     */
    public String postRequestAsString(String parameterString) {
        try {
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(parameterString);
            wr.flush();
            wr.close();

            responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    /**
     * @return response code of the current request.
     */
    public int getResponseCode() {
        return responseCode;
    }
}
