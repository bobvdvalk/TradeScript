package nl.mawoo.tradescript.service.storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scripts")
public class Script {
    @Id
    private Integer id;
    @Column
    private String filename;
    @Column
    private String path;
    @Column
    private Status status;

    public Script(String filename, String path, Status status) {
        this.filename = filename;
        this.path = path;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getPath() {
        return path;
    }

    public Status getStatus() {
        return status;
    }
}
