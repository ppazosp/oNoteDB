package ochat.onotedb.controllers;


import ochat.onotedb.domain.entities.Reminder;
import ochat.onotedb.services.ReminderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Reminder> listReminders(@RequestParam() String subject) {
        List<Reminder> files = reminderService.findBySubject(subject);
        return new ArrayList<>(files);
    }


}
