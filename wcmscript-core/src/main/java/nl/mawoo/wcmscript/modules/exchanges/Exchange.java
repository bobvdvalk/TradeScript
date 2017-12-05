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
