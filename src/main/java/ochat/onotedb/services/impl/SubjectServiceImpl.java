package ochat.onotedb.services.impl;

import ochat.onotedb.domain.entities.Subject;
import ochat.onotedb.repositories.SubjectRepository;
import ochat.onotedb.services.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return StreamSupport
                .stream(
                        subjectRepository.findAll().spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}

