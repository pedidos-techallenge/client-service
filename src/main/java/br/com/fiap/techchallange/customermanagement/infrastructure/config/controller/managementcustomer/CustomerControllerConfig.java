package br.com.fiap.techchallange.customermanagement.infrastructure.config.controller.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerControllerConfig {

    @Bean
    public IGetCustomerController getCustomerController(IGetCustomerUseCase getCustomerUserCase){
        return new GetCustomerController(getCustomerUserCase);
    }

    @Bean
    public IRegisterCustomerController getRegisterCustomerController(IRegisteringCustomerUseCase registerCustomerUserCase){
        return new RegisterCustomerController(registerCustomerUserCase);
    }

    @Bean
    public IChangingCustomerController getChangingCustomer(IChangingCustomerUseCase changingCustomerUserCase){
        return new ChangingCustomerController(changingCustomerUserCase);
    }

    @Bean
    public IRemovalOfCustomerController getRemovalCustomerController(IRemovalOfCustomerUseCase removalOfCustomerUserCase){
        return new RemovalOfCustomerController(removalOfCustomerUserCase);
    }

    @Bean
    public IRemoveAllCustomersController getRemoveAllCustomersController(IRemoveAllCustomersUseCase removeAllCustomersUseCase){
        return new RemoveAllCustomersController(removeAllCustomersUseCase);
    }
}
