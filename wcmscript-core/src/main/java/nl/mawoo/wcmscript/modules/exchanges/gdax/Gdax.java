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
