package studies.uber_clean.notifications.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Bean
    public NotificationFacade notificationFacade(SmsNotificationAdapter smsNotificationAdapter, EmailNotificationAdapter emailNotificationAdapter) {
        return new NotificationFacade(smsNotificationAdapter, emailNotificationAdapter);
    }
}
