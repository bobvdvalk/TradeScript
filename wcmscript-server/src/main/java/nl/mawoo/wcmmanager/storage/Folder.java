package nl.mawoo.wcmmanager.storage;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @JoinColumn
    @ManyToOne
    private Project project;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column
    private String author;

    public Folder(String name, Project project, Date creationDate, String author) {
        this.name = name;
        this.project = project;
        this.creationDate = creationDate;
        this.author = author;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
