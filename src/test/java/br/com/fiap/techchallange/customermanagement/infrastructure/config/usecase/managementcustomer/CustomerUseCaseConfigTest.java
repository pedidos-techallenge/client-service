package br.com.fiap.techchallange.customermanagement.infrastructure.config.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CustomerUseCaseConfigTest {

    @Mock
    ICustomerRepository repository;

    @Test
    void shouldInstantiateCustomerUseCaseConfig() {
        CustomerUseCaseConfig customerUseCaseConfig = new CustomerUseCaseConfig();

        assertDoesNotThrow(() -> {
            customerUseCaseConfig.getCustomerUserCase(repository);
        });

        assertDoesNotThrow(() -> {
            customerUseCaseConfig.changingCustomerUserCase(repository);
        });

        assertDoesNotThrow(() -> {
            customerUseCaseConfig.registerCustomerUserCase(repository);
        });

        assertDoesNotThrow(() -> {
            customerUseCaseConfig.removalOfCustomerUserCase(repository);
        });

        assertDoesNotThrow(() -> {
            customerUseCaseConfig.removeAllCustomersUseCase(repository);
        });
    }
}
