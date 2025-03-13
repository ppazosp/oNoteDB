package ochat.onotedb.domain.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriveFile {
    String id;
    String name;
    String subject;
    String ext;
    String url;
    List<String> classes;
    String owner;
    LocalDate date;
    MultipartFile file;
}

