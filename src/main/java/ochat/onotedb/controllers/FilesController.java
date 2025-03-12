package ochat.onotedb.controllers;


import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.services.FilesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilesController {

    private FilesService fileService;

    public FilesController(FilesService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(path = "/files")
    public List<Files> listFiles() {
        List<Files> files = fileService.findBySubject("Lógica");
        return new ArrayList<>(files);
    }
}