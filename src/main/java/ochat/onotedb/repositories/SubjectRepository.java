package ochat.onotedb.repositories;

import ochat.onotedb.domain.entities.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HexFormat;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, String>{

}
