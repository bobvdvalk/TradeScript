package nl.mawoo.wcmmanager.storage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScriptDao extends JpaRepository<Script, Integer> {
    Script findByName(String name);
}
