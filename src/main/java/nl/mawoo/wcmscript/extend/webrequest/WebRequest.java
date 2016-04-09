package nl.mawoo.wcmscript.extend.webrequest;

import org.apache.http.client.fluent.Request;

/**
 * This class is responsible for web requests
 *
 * @author Bob van der Valk
 */
public class WebRequest {

    private  WebRequest() {
    }

    /**
     * GET web request using the apache library
     *
     * NOTE: this method starts with a capital because end-users can use the libraries documentation.
     * Documentation can be found at: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
     * @param request url you want to send a get request to
     * @return return REQUEST object
     */
    public static Request Get(String request) {
        return Request.Get(request);
    }

    /**
     * POST webrequest using the apache library
     *
     * NOTE: this method starts with a capital because end-users can use the libraries documentation.
     * Documentation can be found at: https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
     * @param request url you want to send a get request to
     * @return REQUEST object
     */
    public static Request Post(String request) {
        return Request.Post(request);
    }

}
