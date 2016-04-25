package nl.mawoo.wcmscript.logger;

/**
 * This class is responible to send messages to the WCMScript manager console.
 *
 * @author Bob van der Valk
 */
public class BroadCaster {
    private String url;

    public static final int ERROR = 712;
    public static final int INFO = 409;
    public static final int WARNING = 364;

    public BroadCaster(String url) {
        this.url = url;
    }

    public void sendMessage(int type, String message) {

    }

    public void sendMessage(int type, String message, Throwable cause) {

    }
}
