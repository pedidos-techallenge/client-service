package br.com.fiap.techchallange.customermanagement.infrastructure.config.presenters.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.presenters.managementcustomer.CustomerPresenterJson;
import br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerPresenterConfig {

    @Bean
    public ICustomerPresenter getCustomerPresenter(){
        return new CustomerPresenterJson();
    }
}
