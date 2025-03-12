package ochat.onotedb.controllers;

import ochat.onotedb.domain.entities.Subject;
import ochat.onotedb.services.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/subjects")
    public List<Subject> listSubjects() {
        List<Subject> subjects = subjectService.findAll();
        return new ArrayList<>(subjects);
    }
}
