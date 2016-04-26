package nl.mawoo.wcmscript.logger;

import nl.mawoo.wcmscript.extend.webrequest.WebRequest;

/**
 * This class is responible to send messages to the WCMScript manager console.
 *
 * @author Bob van der Valk
 */
public class BroadCaster {
    private String url;
    private WebRequest request;

    BroadCaster(String url) {
        this.url = url;
    }

    public void sendMessage(MessageType type, String message) {

    }

    public void sendMessage(MessageType type, String message, Throwable cause) {

    }
}
