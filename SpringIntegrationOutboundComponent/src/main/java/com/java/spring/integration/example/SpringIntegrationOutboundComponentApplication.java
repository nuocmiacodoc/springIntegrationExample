package com.java.spring.integration.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource({"classpath:http-outbound.xml"})
public class SpringIntegrationOutboundComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationOutboundComponentApplication.class, args);
	}
}
