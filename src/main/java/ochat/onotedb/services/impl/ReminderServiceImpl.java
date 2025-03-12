package ochat.onotedb.services.impl;

import ochat.onotedb.domain.entities.Reminder;
import ochat.onotedb.repositories.ReminderRepository;
import ochat.onotedb.services.ReminderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ReminderServiceImpl implements ReminderService {
    private ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public List<Reminder> findBySubject(String subject) {
        return StreamSupport.stream(reminderRepository
                                .findBySubject(subject)
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
