package nl.mawoo.wcmscript.modules.trader;

import nl.mawoo.wcmscript.AbstractScriptModule;

public class Management extends AbstractScriptModule {

    public Trade trade() {
        return new Trade();
    }

    public Bunq bankAccount() {
        return new Bunq();
    }
}
