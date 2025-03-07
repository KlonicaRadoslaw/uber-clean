package studies.uber_clean.users.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Bean
    public UserFacade userFacade(UserRepository userRepository) {
        return new UserFacade(userRepository);
    }
}
