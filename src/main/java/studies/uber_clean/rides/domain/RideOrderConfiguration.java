package studies.uber_clean.rides.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RideOrderConfiguration {
    @Bean
    public RideOrderFacade rideOrderFacade(RideOrderRepository rideOrderRepository) {
        return new RideOrderFacade(rideOrderRepository);
    }
}
