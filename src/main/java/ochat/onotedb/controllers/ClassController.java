package ochat.onotedb.controllers;

import ochat.onotedb.domain.entities.Class;
import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.services.ClassService;
import ochat.onotedb.services.FilesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassController {

    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(path = "/classes")
    public List<Class> listFiles(@RequestParam() String subject) {
        List<Class> files = classService.findBySubject(subject);
        return new ArrayList<>(files);
    }
}
