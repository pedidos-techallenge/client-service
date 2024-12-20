package br.com.fiap.techchallange.customermanagement.infrastructure.config.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUseCaseConfig {

    @Bean
    public IGetCustomerUseCase getCustomerUserCase(ICustomerRepository repository){
        return new GetCustomerUseCase(repository);
    }

    @Bean
    public IRegisteringCustomerUseCase registerCustomerUserCase(ICustomerRepository repository){
        return new RegisteringCustomerUseCase(repository);
    }

    @Bean
    public IChangingCustomerUseCase changingCustomerUserCase(ICustomerRepository repository){
        return new ChangingCustomerUseCase(repository);
    }

    @Bean
    public IRemovalOfCustomerUseCase removalOfCustomerUserCase(ICustomerRepository repository){
        return new RemovalOfCustomerUseCase(repository);
    }

    @Bean
    public IRemoveAllCustomersUseCase removeAllCustomersUseCase(ICustomerRepository repository) {
        return new RemoveAllCustomersUseCase(repository);
    }

}
