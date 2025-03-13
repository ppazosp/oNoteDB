package ochat.onotedb.services.impl;

import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.repositories.FilesRepository;
import ochat.onotedb.services.FilesService;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FilesServiceImpl implements FilesService {

    private FilesRepository fileRepository;

    public FilesServiceImpl(FilesRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<Files> findBySubject(String subject) {
        return StreamSupport.stream(fileRepository
                                .findBySubject(subject)
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Files> findById(String id) {
        return fileRepository.findById(id);
    }

    @Override
    public List<Files> getFilesByClassAndSubject(String className, String subject) {
        return fileRepository.findByClassesInAndSubject(Collections.singletonList(className), subject);
    }

    @Override
    public Files save(Files files) {
        return fileRepository.save(files);
    }
}