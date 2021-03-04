package org.sbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication()//exclude = {JacksonAutoConfiguration.class})
public class ApplicationServeur {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationServeur.class, args);
	}

}
