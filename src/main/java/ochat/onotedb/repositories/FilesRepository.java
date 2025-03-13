package ochat.onotedb.repositories;

import ochat.onotedb.domain.entities.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilesRepository extends CrudRepository<Files, String> {

    Iterable<Files> findBySubject(String subject);

    List<Files> findByClassesInAndSubject(List<String> classNames, String subject);
}
