package ochat.onotedb.services.impl;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import ochat.onotedb.domain.entities.Files;
import ochat.onotedb.domain.entities.dto.DriveFile;
import ochat.onotedb.services.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    private Drive googleDriveClient;

    @Value("${google.shared.folder.id}")
    private String sharedFolderId;

    @Override
    public String uploadFile(MultipartFile data) throws IOException {
        try {
            File fileMetadata = new File();
            fileMetadata.setName(data.getName());




            // Si hay un folder compartido, agrégalo
            if (sharedFolderId != null && !sharedFolderId.isEmpty()) {
                fileMetadata.setParents(Collections.singletonList(sharedFolderId));
            }

            InputStreamContent mediaContent = new InputStreamContent(
                    data.getContentType(), data.getInputStream());

            File uploadedFile = googleDriveClient.files()
                    .create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();

            // Hacer público el archivo
            Permission permission = new Permission()
                    .setType("anyone")
                    .setRole("reader");
            googleDriveClient.permissions().create(uploadedFile.getId(), permission).execute();

            return "https://drive.google.com/uc?id=" + uploadedFile.getId();
        } catch (Exception e) {
            throw new IOException("Error al subir el archivo a Google Drive: " + e.getMessage(), e);
        }
    }
}
