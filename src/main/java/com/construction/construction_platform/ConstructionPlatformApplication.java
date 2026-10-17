package com.construction.construction_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "com.construction.construction_platform")
@ComponentScan(basePackages = "com.construction.construction_platform")
public class ConstructionPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionPlatformApplication.class, args);
	}
}