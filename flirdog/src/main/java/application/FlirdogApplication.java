package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"application", "user.*", "product.*", "matching.*", "community.*"})
@EntityScan({"user.bean", "product.bean", "matching.bean", "community.bean"})
@EnableJpaRepositories({"user.repository", "product.repository", "matching.repository", "community.repository"})
public class FlirdogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlirdogApplication.class, args);
	}

}