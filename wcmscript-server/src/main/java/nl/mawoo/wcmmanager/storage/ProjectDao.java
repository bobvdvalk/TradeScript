package nl.mawoo.wcmmanager.storage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Integer> {
    Project findByName(String name);
}
