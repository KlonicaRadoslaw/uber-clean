package studies.uber_clean.notifications;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studies.uber_clean.notifications.domain.EmailNotificationAdapter;
import studies.uber_clean.notifications.domain.NotificationService;
import studies.uber_clean.notifications.domain.SmsNotificationAdapter;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final SmsNotificationAdapter smsNotificationAdapter;
    private final EmailNotificationAdapter emailNotificationAdapter;

    public NotificationController(SmsNotificationAdapter smsNotificationAdapter, EmailNotificationAdapter emailNotificationAdapter) {
        this.smsNotificationAdapter = smsNotificationAdapter;
        this.emailNotificationAdapter = emailNotificationAdapter;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestParam String type, @RequestParam String recipient, @RequestParam String message) {
        NotificationService service;

        switch (type.toLowerCase()) {
            case "sms" -> service = smsNotificationAdapter;
            case "email" -> service = emailNotificationAdapter;
            default -> {
                return "Invalid notification type";
            }
        }

        service.sendNotification(recipient, message);
        return "Notification sent successfully";
    }
}