package ochat.onotedb.services;

import ochat.onotedb.domain.entities.Reminder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReminderService {
    List<Reminder> findBySubject(String subject);
}
