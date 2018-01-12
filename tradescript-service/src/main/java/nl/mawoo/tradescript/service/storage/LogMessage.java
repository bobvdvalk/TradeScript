package nl.mawoo.tradescript.service.storage;

import javax.persistence.*;

@Entity
@Table(name = "log_messages")
public class LogMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String filename;

    @Column
    private String message;

    @Column
    private String datetime;

    public LogMessage() {
    }

    public LogMessage(String filename, String message, String datetime) {
        this.filename = filename;
        this.message = message;
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
