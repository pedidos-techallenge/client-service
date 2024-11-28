package br.com.fiap.techchallange.customermanagement.infrastructure.config;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.GetCustomerController;
import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.IGetCustomerController;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer.GetCustomerUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class CustomerControllerConfigTest {
    @Mock
    IGetCustomerController iGetCustomerController;

    GetCustomerController getCustomerController;

    @Mock
    IGetCustomerUseCase iGetCustomerUseCase;

    GetCustomerUseCase getCustomerUseCase;

    @Test
    void shouldGetCustomerController() {
        getCustomerController = new GetCustomerController(iGetCustomerUseCase);

        getCustomerController.invoke("12345678900");
    }
}
