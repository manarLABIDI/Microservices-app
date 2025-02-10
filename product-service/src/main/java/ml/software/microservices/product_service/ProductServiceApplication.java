package ml.software.microservices.product_service;

import com.mongodb.client.MongoClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(MongoClient mongoClient) {
		return args -> {
			String details = "MongoClient Class: " + mongoClient.getClass().getName() + "\n" +
					"MongoDB URI: " + mongoClient.getClusterDescription().toString();

			System.out.println(details);
		};
	}

}
