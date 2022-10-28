package tech.gearsofcode.petclinic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@Configuration
@RestController
public class PetclinicWemfApplication {
	@RequestMapping("/hello")
	String home() {
		return "Hello World!";
	}



	public static void main(String[] args) throws Exception {
		SpringApplication.run(PetclinicWemfApplication.class, args);
	}
}
