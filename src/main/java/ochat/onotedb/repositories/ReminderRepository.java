package ochat.onotedb.repositories;

import ochat.onotedb.domain.entities.Reminder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends CrudRepository<Reminder, String> {

    Iterable<Reminder> findBySubject(String subject);
}
