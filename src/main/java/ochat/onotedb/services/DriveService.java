package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.domain.entities.dto.DriveFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DriveService {
    String uploadFile(MultipartFile file) throws IOException;
}
