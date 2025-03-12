package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
}
