package nl.mawoo.wcmmanager.storage;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JoinColumn
    @ManyToOne
    private Folder folder;

    @Column
    private String content;

    @Column(name = "creation_date")
    private Date creationDate;

    public Script(String name, Folder folder, String content, Date creationDate) {
        this.name = name;
        this.folder = folder;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
