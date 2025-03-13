package ochat.onotedb.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Class {
    String id;
    String name;
    String teacher;
    String start_date;
    String end_date;
    String subject;

    String resume = "NO RESUME";
    String transcript = "NO TRANSCRIPT";
}

