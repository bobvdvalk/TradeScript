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
package nl.mawoo.wcmscript.modules.exchanges;

public interface Exchange {
    String currentPrice(String product);

    String orderbook(String product);

    String publicTransactions(String product);

    void setApiPublic(String publicKey);

    void setApiPrivate(String privateKey);

    String accountBalance();

    String transactions();
    /**
     * Get the whole portfolio from the exchange that you are using
     * @return
     */
    String portfolio();

    /**
     * Place a buy order
     * @param product you want to buy. Example: ETHUSD
     * @param amount money
     * @param currency example EUR
     * @return
     */
    String placeBuyOrder(String product, String amount, String currency);

    /**
     * Place a sell order
     * @param product you want to sell. Example: ETHUSD
     * @param amount money
     * @param currency example EUR
     * @return
     */
    String placeSellOrder(String product, String amount, String currency);
}
