package studies.uber_clean.rides.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RideConfiguration {
    @Bean
    public RideFacade rideFacade(RideRepository rideRepository) {
        return new RideFacade(rideRepository);
    }
}
