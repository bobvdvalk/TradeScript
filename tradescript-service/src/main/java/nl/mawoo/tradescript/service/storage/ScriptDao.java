package nl.mawoo.tradescript.service.storage;

import org.springframework.data.repository.CrudRepository;

public interface ScriptDao extends CrudRepository<Script, Integer> {

    Script findByFilename(String filename);

    Iterable<Script> findAllByStatus(Status status);
}
