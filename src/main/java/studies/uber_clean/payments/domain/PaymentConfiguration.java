package studies.uber_clean.payments.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studies.uber_clean.rides.domain.RideOrderFacade;
import studies.uber_clean.rides.domain.RideOrderRepository;

@Configuration
public class PaymentConfiguration {
    @Bean
    public ExternalPaymentProcessor externalPaymentProcessor() {
        return new ExternalPaymentProcessor();
    }

    @Bean
    public PaymentProcessor paymentProcessor(ExternalPaymentProcessor externalPaymentProcessor) {
        return new PaymentAdapter(externalPaymentProcessor);
    }

    @Bean
    public PaymentFacade paymentFacade(PaymentProcessor paymentProcessor) {
        return new PaymentFacade(paymentProcessor);
    }
}
