package com.secure.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.secure.app"})
public class SpringSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}

}
