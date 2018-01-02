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
package nl.mawoo.wcmscript.modules.exchanges.gdax;

import nl.mawoo.wcmscript.modules.exchanges.Exchange;

public class Gdax implements Exchange {
    private String publicKey;
    private String privateKey;

    @Override
    public String currentPrice(String product) {
        return null;
    }

    @Override
    public String orderbook(String product) {
        return null;
    }

    @Override
    public String publicTransactions(String product) {
        return null;
    }

    @Override
    public void setApiPublic(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public void setApiPrivate(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String accountBalance() {
        return null;
    }

    @Override
    public String transactions() {
        return null;
    }

    @Override
    public String portfolio() {
        return null;
    }

    @Override
    public String placeBuyOrder(String product, String amount, String currency) {
        return null;
    }

    @Override
    public String placeSellOrder(String product, String amount, String currency) {
        return null;
    }
}
