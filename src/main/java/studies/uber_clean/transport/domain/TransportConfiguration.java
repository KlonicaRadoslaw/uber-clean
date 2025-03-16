package studies.uber_clean.transport.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studies.uber_clean.rides.domain.RideOrderFacade;
import studies.uber_clean.rides.domain.RideOrderRepository;

@Configuration
public class TransportConfiguration {
    @Bean
    public TransportFacade transportFacade() {
        return new TransportFacade();
    }
}
