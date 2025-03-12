package ochat.onotedb.controllers;


import ochat.onotedb.domain.entities.Reminder;
import ochat.onotedb.services.ReminderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReminderController {

    private ReminderService reminderService;
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping(path = "/reminders")
    public List<Reminder> listReminders() {
        List<Reminder> files = reminderService.findBySubject("Lógica");
        return new ArrayList<>(files);
    }


}
