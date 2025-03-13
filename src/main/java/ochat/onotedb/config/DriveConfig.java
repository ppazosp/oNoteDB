package ochat.onotedb.config;

import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Configuration
public class DriveConfig {

    private static final String APPLICATION_NAME = "oNote";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance(); // Cambiado a Gson

    @Value("${google.credentials.path}")
    private String credentialsPath;

    @Bean
    public Drive googleDriveClient() throws GeneralSecurityException, IOException {
        GoogleCredentials credentials;
        System.out.println(credentialsPath);

        try (FileInputStream credentialsStream = new FileInputStream(credentialsPath)) {
            credentials = GoogleCredentials.fromStream(credentialsStream)
                    .createScoped(Collections.singletonList(DriveScopes.DRIVE_FILE));
            System.out.println("✅ Credenciales de Google Drive cargadas correctamente.");
        } catch (IOException e) {
            throw new IOException("❌ Error al cargar las credenciales de Google Drive: " + e.getMessage(), e);
        }

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), // No requiere cast
                JSON_FACTORY,
                new HttpCredentialsAdapter(credentials) // Usa HttpCredentialsAdapter correctamente
        ).setApplicationName(APPLICATION_NAME).build();
    }
}