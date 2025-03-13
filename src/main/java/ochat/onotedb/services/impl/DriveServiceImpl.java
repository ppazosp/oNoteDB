package ochat.onotedb.services.impl;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import ochat.onotedb.services.DriveService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;

@Service
public class DriveServiceImpl implements DriveService {

    private final Drive googleDriveClient;

    @Value("${google.shared.folder.id}")
    private String sharedFolderId;

    public DriveServiceImpl(Drive googleDriveClient) {
        this.googleDriveClient = googleDriveClient;
    }

    @Override
    public String uploadFile(String base64Data, String fileName, String mimeType) throws IOException {
        try {
            // Decodificar Base64
            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);

            // Crear metadata del archivo
            File fileMetadata = new File();
            fileMetadata.setName(fileName);

            if (sharedFolderId != null && !sharedFolderId.isEmpty()) {
                fileMetadata.setParents(Collections.singletonList(sharedFolderId));
            }

            InputStreamContent mediaContent = new InputStreamContent(mimeType, inputStream);

            File uploadedFile = googleDriveClient.files()
                    .create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();

            // Hacer público el archivo
            Permission permission = new Permission()
                    .setType("anyone")
                    .setRole("reader");
            googleDriveClient.permissions().create(uploadedFile.getId(), permission).execute();

            return "https://drive.google.com/uc?export=download&id=" + uploadedFile.getId();

        } catch (IOException e) {
            throw new IOException("Error al subir el archivo a Google Drive: " + e.getMessage(), e);
        }
    }
}