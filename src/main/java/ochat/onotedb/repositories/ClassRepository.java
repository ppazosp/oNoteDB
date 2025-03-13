package ochat.onotedb.repositories;

import org.springframework.data.repository.CrudRepository;
import ochat.onotedb.domain.entities.Class;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends CrudRepository<Class, String> {

    Iterable<Class> findBySubject(String subject);

    Optional<Class> findByNameAndSubject(String name, String subject);
}
