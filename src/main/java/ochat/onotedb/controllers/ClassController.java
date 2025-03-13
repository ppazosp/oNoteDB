package ochat.onotedb.controllers;

import ochat.onotedb.domain.entities.Class;
import ochat.onotedb.services.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/class")
    public ResponseEntity<Class> getClass(@RequestParam String name, @RequestParam String subject) {
        return classService.findByNameAndSubject(name, subject)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @PostMapping(path = "/resume")
    public ResponseEntity<String> updateClassWithResume(@RequestBody Class classs) {
        Optional<Class> existingClass = classService.findByNameAndSubject(classs.getName(), classs.getSubject());

        if (existingClass.isPresent()) {
            Class classToUpdate = existingClass.get();
            classToUpdate.setResume(classs.getResume());
            classService.save(classToUpdate);
            return ResponseEntity.ok("Resume updated successfully.");
        } else {
            return ResponseEntity.status(404).body("Class not found.");
        }
    }
}
