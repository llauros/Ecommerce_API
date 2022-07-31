package ecmdomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("ecmdomain.entities")
@SpringBootApplication
public class EcmdomainLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcmdomainLibApplication.class, args);
	}

}
