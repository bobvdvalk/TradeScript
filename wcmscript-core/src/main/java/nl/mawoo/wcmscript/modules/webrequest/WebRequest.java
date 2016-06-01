/**
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.mawoo.wcmscript.modules.webrequest;

import org.apache.http.client.fluent.Request;

/**
 * This class is responsible to run web requests
 *
 * @author Bob van der Valk
 */
public class WebRequest {
    public WebRequest() {
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
