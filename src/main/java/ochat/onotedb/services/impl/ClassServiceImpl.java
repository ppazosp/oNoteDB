package ochat.onotedb.services.impl;
import ochat.onotedb.domain.entities.Class;
import ochat.onotedb.services.ClassService;
import ochat.onotedb.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> findBySubject(String subject) {
        return StreamSupport.stream(classRepository
                                .findBySubject(subject)
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
