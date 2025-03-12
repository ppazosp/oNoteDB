package ochat.onotedb.domain.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reminder {
    String id;
    String name;
    String date;
    String description;
    String subject;
}
