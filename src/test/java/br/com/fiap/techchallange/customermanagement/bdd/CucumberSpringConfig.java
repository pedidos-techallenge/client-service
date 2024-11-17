package br.com.fiap.techchallenge.customermanagement.bdd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CucumberSpringConfig {

    @Bean
    public SharedData sharedData() {
        return new SharedData();
    }
}