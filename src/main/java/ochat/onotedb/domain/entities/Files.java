package ochat.onotedb.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Files {
    String id;
    String name;
    String subject;
    String ext;
    String url;
    List<String> classes;
    String owner;
    LocalDate date;
}
