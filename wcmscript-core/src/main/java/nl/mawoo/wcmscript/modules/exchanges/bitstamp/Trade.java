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
package nl.mawoo.wcmscript.modules.exchanges.bitstamp;

import com.google.gson.Gson;
import nl.mawoo.wcmscript.logger.ScriptLogger;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;

public class Trade {
    private final ScriptLogger logger;
    private final String publicKey;
    private final String privateKey;

    public Trade(ScriptLogger logger, String publicKey, String privateKey) {
        this.logger = logger;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String balance(String product) {
        String data = "";
        try {
            Response request = Request.Post("https://www.bitstamp.net/api/v2/balance/")
                    .addHeader("key", this.publicKey)
                    .addHeader("signature", this.privateKey)
                    .addHeader("nounce", "")
                    .execute();
            data = request.returnContent().asString();
        } catch (IOException e) {
            logger.error("Something went wrong doing the request", e);
        }
        return new Gson().toJson(data);
    }
}
