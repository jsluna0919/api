package co.floristeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class ApiFloristeriaApplication {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
		SpringApplication.run(ApiFloristeriaApplication.class, args);
	}

}
