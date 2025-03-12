package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Class;
import ochat.onotedb.domain.entities.Files;

import java.util.List;


public interface ClassService {

    List<Class> findBySubject(String subject);
}
