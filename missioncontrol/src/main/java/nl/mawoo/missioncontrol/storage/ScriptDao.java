package nl.mawoo.missioncontrol.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ScriptDao extends JpaRepository<Script, Integer> {
}
