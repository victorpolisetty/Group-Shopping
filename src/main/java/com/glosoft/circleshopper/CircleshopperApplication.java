package com.glosoft.circleshopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableAutoConfiguration(exclude = {
		SecurityAutoConfiguration.class
})
@SpringBootApplication
@EnableJpaAuditing
public class CircleshopperApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircleshopperApplication.class, args);
	}

}
