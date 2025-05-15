package studies.uber_clean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"studies.uber_clean.discounts"})
public class UberCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberCleanApplication.class, args);
	}

}
