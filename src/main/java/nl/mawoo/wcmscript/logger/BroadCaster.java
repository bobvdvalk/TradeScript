package nl.mawoo.wcmscript.logger;

/**
 * This class is responible to send messages to the WCMScript manager console.
 *
 * @author Bob van der Valk
 */
public class BroadCaster {
    private String url;

    public BroadCaster(String url) {
        this.url = url;
    }

    public void sendMessage(String type, String message) {

    }

    public void sendMessage(String type, String message, Throwable cause) {

    }
}
