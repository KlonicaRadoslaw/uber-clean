package studies.uber_clean.notifications;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studies.uber_clean.notifications.domain.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationFacade notificationFacade;

    public NotificationController(NotificationFacade notificationFacade) {
        this.notificationFacade = notificationFacade;
    }

    @PostMapping("/payment")
    public String sendPaymentNotification(@RequestParam String type, @RequestParam String recipient, @RequestParam String message) {
        return notificationFacade.sendPaymentNotification(type, recipient, message);
    }

    @PostMapping("/promotion")
    public String sendPromotionNotification(@RequestParam String type, @RequestParam String recipient, @RequestParam String message) {
        return notificationFacade.sendPromotionNotification(type, recipient, message);
    }
}
