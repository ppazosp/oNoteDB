package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Files;

import java.util.List;
import java.util.Optional;

public interface FilesService {

    List<Files> findBySubject(String subject);

    Optional<Files> findById(String id);

    List<Files> getFilesByClassAndSubject(String className, String subject);

    Files save(Files files);
}
