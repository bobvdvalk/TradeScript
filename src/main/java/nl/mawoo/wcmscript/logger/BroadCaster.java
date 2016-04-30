package nl.mawoo.wcmscript.logger;

import nl.mawoo.wcmscript.extend.dbconnector.DbConnector;
import org.apache.log4j.Logger;

/**
 * This class is responsible sto send messages to the WCMScript manager console.
 *
 * @author Bob van der Valk
 */
public class BroadCaster {
    private String url;
    private int sessionId;

    private DbConnector mysql;
    private Logger logger = Logger.getLogger(BroadCaster.class.getName());

    /**
     * Set the manager url and set the session id
     * @param url the url where the manager is located
     * @param sessionId the current session id of the user
     */
    BroadCaster(String url, int sessionId) {
        this.url = url;
        this.sessionId = sessionId;

        try {
            mysql = new DbConnector("jdbc:mysql://localhost/wcmsmanager", "root", "");
        } catch (ClassNotFoundException e) {
            logger.error("Cannot connect to mysql database", e);
        }

    }

    public void sendMessage(MessageType type, String message) {
        String query = "INSERT INTO `console` (`session_id`, `message`, `type`, `time`) VALUES ("+ sessionId +", '"+ message +"', '"+ type.toString()+"', '2016-05-01 00:05:59');";
        mysql.query(query);
    }

    public void sendMessage(MessageType type, String message, Throwable cause) {
        String query = "INSERT INTO `console` (`session_id`, `message`, `type`, `time`) VALUES ("+ sessionId +", '"+ message + "-"+ cause.toString() +"', '"+ type.toString()+"', '2016-05-01 00:05:59');";
        mysql.query(query);
    }
}
