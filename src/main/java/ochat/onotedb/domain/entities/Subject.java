package ochat.onotedb.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    String id;
    String name;
    Binary photo;
}
