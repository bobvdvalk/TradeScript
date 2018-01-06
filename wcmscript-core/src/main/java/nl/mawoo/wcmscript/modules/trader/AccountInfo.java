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
package nl.mawoo.wcmscript.modules.trader;

import com.bunq.sdk.model.generated.object.Amount;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    private final Integer id;
    private final String description;
    private final Integer userId;
    private final Amount balance;

    /**
     * Bunq user account object
     * @param id monetary id
     * @param description
     * @param userId
     * @param balance
     */
    public AccountInfo(Integer id, String description, Integer userId, Amount balance) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUserId() {
        return userId;
    }

    public Amount getBalance() {
        return balance;
    }
}
