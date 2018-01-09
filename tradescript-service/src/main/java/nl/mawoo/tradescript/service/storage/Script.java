package nl.mawoo.tradescript.service.storage;

import javax.persistence.*;

@Entity
@Table(name = "scripts")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String filename;
    @Column
    private String path;
    @Column
    private Status status;

    public Script() {
    }

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
