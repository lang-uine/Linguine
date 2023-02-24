package com.Linguine;

import lombok.RequiredArgsConstructor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class LinguineApplication {
	public static void main(String[] args) {
		SpringApplication.run(LinguineApplication.class, args);
	}


}
