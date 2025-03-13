package ochat.onotedb.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DriveService {
    String uploadFile(MultipartFile file) throws IOException;
}
