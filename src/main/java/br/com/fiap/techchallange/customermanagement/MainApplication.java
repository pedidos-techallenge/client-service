package br.com.fiap.techchallange.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.techchallange.customermanagement.infrastructure.adapters",
		                       "br.com.fiap.techchallange.customermanagement.infrastructure.factory",
		                       "br.com.fiap.techchallange.customermanagement.infrastructure.config",
		                       "br.com.fiap.techchallange.customermanagement.adapters.gateways.repository",
		                       "br.com.fiap.techchallange.customermanagement.infrastructure.bd",
							   "br.com.fiap.techchallange.customermanagement.infrastructure.api"
								} )
public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Environment: " + System.getenv("SPRING_PROFILES_ACTIVE"));
		SpringApplication.run(MainApplication.class, args);
	}
}
