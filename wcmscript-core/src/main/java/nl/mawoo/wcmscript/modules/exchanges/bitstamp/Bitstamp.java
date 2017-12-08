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

import nl.mawoo.wcmscript.AbstractScriptModule;
import nl.mawoo.wcmscript.modules.exchanges.Exchange;
import nl.mawoo.wcmscript.modules.webrequest.WebRequest;

import java.io.IOException;

public class Bitstamp extends AbstractScriptModule implements Exchange {
    private String publicKey = "";
    private String privateKey = "";

    public String currentPrice(String product) {
        getScriptLogger().debug("Bitstamp - Getting current price of: " + product);
        String url = "https://www.bitstamp.net/api/v2/ticker/" + product + "/";
        WebRequest request = new WebRequest();
        try {
            //String output = request.get(url).execute().returnContent().asString();
            return request.get(url).execute().returnContent().asString();
        } catch (IOException e) {
            getScriptLogger().error("Something went wrong with the request", e);
        }
        return null;
    }

    @Override
    public String orderbook(String product) {
        String url = "https://www.bitstamp.net/api/v2/order_book/"+ product +"/";
        WebRequest request = new WebRequest();
        try {
            return request.get(url).execute().returnContent().asString();
        } catch (IOException e) {
            getScriptLogger().error("Something went wrong with the request", e);
        }
        return null;
    }

    @Override
    public String publicTransactions(String product) {
        String url = " https://www.bitstamp.net/api/v2/transactions/"+ product +"/";
        WebRequest request = new WebRequest();
        try {
            return request.get(url).execute().returnContent().asString();
        } catch (IOException e) {
            getScriptLogger().error("Something went wrong with the request", e);
        }
        return null;
    }

    @Override
    public void setApiPublic(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public void setApiPrivate(String privateKey) {
        this.publicKey = privateKey;
    }

    @Override
    public String accountBalance() {
        getScriptLogger().error("Bitstamp - accountBalance() not implemented");
        return null;
    }

    @Override
    public String transactions() {
        getScriptLogger().error("Bitstamp - getTransactions() not implemented");
        return null;
    }

    @Override
    public String portfolio() {
        if(this.keysSet()) {
            getScriptLogger().error("Bitstamp - getPortfolio() not implemented");
        }
        return null;
    }

    @Override
    public String placeBuyOrder(String product, String amount, String currency) {
        getScriptLogger().error("Bitstamp - placeBuyOrder() not implemented");
        return null;
    }

    @Override
    public String placeSellOrder(String product, String amount, String currency) {
        getScriptLogger().error("Bitstamp - placeSellOrder() not implemented");
        return null;
    }

    /**
     * Check if the private and public keys are set
     * @return boolean
     */
    private boolean keysSet() {
        boolean set;
        if(this.publicKey.isEmpty() || this.privateKey.isEmpty()) {
            set = false;
            getScriptLogger().error("You have to set the keys before you can place orders!");
        } else {
            set = true;
        }
        return set;
    }
}
