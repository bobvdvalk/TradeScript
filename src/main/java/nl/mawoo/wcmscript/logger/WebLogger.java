package nl.mawoo.wcmscript.logger;

import nl.mawoo.wcmscript.extend.dbconnector.DbConnector;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is responsible to log stuff to the web
 *
 * @author Bob van der Valk
 */
public class WebLogger extends AbstractLogger {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private DbConnector mysql;
    private String sessionId;
    private String currentDate;

    public WebLogger(String sessionId) {
        this.sessionId = sessionId;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        currentDate = dateFormat.format(date);

        try {
            mysql = new DbConnector("jdbc:mysql://localhost/wcmsmanager", "root", "");
        } catch (ClassNotFoundException e) {
            logger.error("Cannot connect to mysql database", e);
        }
    }


    @Override
    protected void logMessage(MessageType type, String message) {
        String query = "INSERT INTO `console` (`session_id`, `message`, `type`, `time`) VALUES ('"+ sessionId +"', '"+ message +"', '"+ type.toString()+"', '"+ currentDate +"');";
        mysql.query(query);
    }

    @Override
    protected void logMessage(MessageType type, String message, Throwable cause) {
        String query = "INSERT INTO `console` (`session_id`, `message`, `type`, `time`) VALUES ('"+ sessionId +"', '"+ message + "-"+ cause.toString() +"', '"+ type.toString()+"', '"+ currentDate +"');";
        mysql.query(query);
    }
}
