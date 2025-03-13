package ochat.onotedb.controllers;

import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.services.ClassService;
import ochat.onotedb.services.DriveService;
import ochat.onotedb.services.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ochat.onotedb.domain.entities.dto.DriveFile;

import java.io.IOException;

@RestController
public class DriveController {

    @Autowired
    private FilesService filesService;

    private DriveService driveService;

    public DriveController(FilesService filesService, DriveService driveService) {
        this.filesService = filesService;
        this.driveService = driveService;
    }

    @PutMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody DriveFile file) {
        try {
            String url = driveService.uploadFile(file.getFile());
            Files fileDB = new Files();
            fileDB.setName(file.getName());
            fileDB.setSubject(file.getSubject());
            fileDB.setExt(file.getExt());
            fileDB.setUrl(url);
            fileDB.setClasses(file.getClasses());
            fileDB.setOwner(file.getOwner());
            fileDB.setDate(file.getDate());
            filesService.save(fileDB);
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }
}
