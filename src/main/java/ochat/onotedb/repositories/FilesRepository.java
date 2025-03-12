package ochat.onotedb.repositories;

import ochat.onotedb.domain.entities.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends CrudRepository<Files, String> {

    Iterable<Files> findBySubject(String subject);
}
