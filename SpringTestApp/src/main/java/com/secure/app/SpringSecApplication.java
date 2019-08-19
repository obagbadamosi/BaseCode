package com.secure.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication(scanBasePackages = {"com.secure.app"})
public class SpringSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}
	
	@Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setCacheSeconds(3600); // Refresh cache once per hour.
        return source;
    }
}
