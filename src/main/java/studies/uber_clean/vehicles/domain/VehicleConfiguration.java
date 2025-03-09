package studies.uber_clean.vehicles.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfiguration {
    @Bean
    public VehicleFacade vehicleFacade(VehicleRepository vehicleRepository) {
        return new VehicleFacade(vehicleRepository);
    }
}
