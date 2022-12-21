package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelGp51Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelGp51Application.class, args);
	}

}
