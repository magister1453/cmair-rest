package za.co.cmair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class CmairApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmairApplication.class, args);
	}
}
