package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Class;
import ochat.onotedb.domain.entities.Files;

import java.util.List;
import java.util.Optional;

public interface ClassService {

    List<Class> findBySubject(String subject);

    Optional<Class> findByNameAndSubject(String name, String subject);

    Class save(Class classs);
}
