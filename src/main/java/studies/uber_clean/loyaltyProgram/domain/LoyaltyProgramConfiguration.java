package studies.uber_clean.loyaltyProgram.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoyaltyProgramConfiguration {
    @Bean
    public LoyaltyProgramFacade loyaltyProgramFacade() {
        return new LoyaltyProgramFacade();
    }
}
