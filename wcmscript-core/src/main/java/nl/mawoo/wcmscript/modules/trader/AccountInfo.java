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
