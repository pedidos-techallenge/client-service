package br.com.fiap.techchallange.customermanagement.infrastructure.config.controller.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.infrastructure.config.controller.managementcustomer.CustomerControllerConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerConfigTest {

    @Mock
    IGetCustomerUseCase getCustomerUserCase;

    @Mock
    IChangingCustomerUseCase changingCustomerUseCase;

    @Mock
    IRegisteringCustomerUseCase registeringCustomerUseCase;

    @Mock
    IRemovalOfCustomerUseCase removalOfCustomerUseCase;

    @Mock
    IRemoveAllCustomersUseCase removeAllCustomersUseCase;

    @Test
    void shouldInstantiateConfigCustomerController() {
        CustomerControllerConfig customerControllerConfig = new CustomerControllerConfig();

        assertDoesNotThrow(() -> {
            customerControllerConfig.getCustomerController(getCustomerUserCase);
        });

        assertDoesNotThrow(() -> {
            customerControllerConfig.getRegisterCustomerController(registeringCustomerUseCase);
        });

        assertDoesNotThrow(() -> {
            customerControllerConfig.getChangingCustomer(changingCustomerUseCase);
        });

        assertDoesNotThrow(() -> {
            customerControllerConfig.getRemovalCustomerController(removalOfCustomerUseCase);
        });

        assertDoesNotThrow(() -> {
            customerControllerConfig.getRemoveAllCustomersController(removeAllCustomersUseCase);
        });
    }
}
