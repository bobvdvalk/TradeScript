/**
 * Copyright 2016 Mawoo Nederland
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.mawoo.wcmscript.modules.trader;

import com.bunq.sdk.context.ApiContext;
import com.bunq.sdk.context.ApiEnvironmentType;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.model.generated.endpoint.MonetaryAccount;
import com.bunq.sdk.model.generated.endpoint.MonetaryAccountBank;
import com.bunq.sdk.model.generated.endpoint.Payment;
import com.google.gson.Gson;
import nl.mawoo.wcmscript.AbstractScriptModule;

import java.util.List;

public class Bunq extends AbstractScriptModule {
    //todo: put this in property file
    private static final String API_KEY = "";
    private static final String DEVICE_DESCRIPTION = "TradeScript";
    private static final String API_CONTEXT_FILE_PATH = "bunq.conf";

    private ApiContext apiContext;

    public void init() {
        this.apiContext = ApiContext.create(ApiEnvironmentType.PRODUCTION, API_KEY, DEVICE_DESCRIPTION);
        this.apiContext.save(API_CONTEXT_FILE_PATH);
    }

    /**
     * Get all bunq bank account details
     *
     * @return
     */
    public String account() {
        MonetaryAccount account = MonetaryAccount.get(this.apiContext, 197309, 648539).getValue();
        MonetaryAccountBank bank = account.getMonetaryAccountBank();
        AccountInfo accountInfo = new AccountInfo(bank.getId(), bank.getDescription(), bank.getUserId(), bank.getBalance());
        return new Gson().toJson(accountInfo);
    }

    public List<Payment> getPayments() {
        BunqResponse<List<Payment>> paymentListResponse = Payment.list(
                apiContext,
                197309,
                648539
        );
        return paymentListResponse.getValue();
    }
}
