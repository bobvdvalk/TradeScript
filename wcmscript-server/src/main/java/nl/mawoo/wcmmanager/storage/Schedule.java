package nl.mawoo.wcmmanager.storage;

import javax.persistence.*;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @JoinColumn
    @ManyToOne
    private Script script;

    @Column
    private String runEvery;

    public Schedule(String name, String description, Script script, String runEvery) {
        this.name = name;
        this.description = description;
        this.script = script;
        this.runEvery = runEvery;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public String getRunEvery() {
        return runEvery;
    }

    public void setRunEvery(String runEvery) {
        this.runEvery = runEvery;
    }
}
