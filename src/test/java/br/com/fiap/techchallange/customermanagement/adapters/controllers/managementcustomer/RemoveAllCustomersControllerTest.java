package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemoveAllCustomersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class RemoveAllCustomersControllerTest {
    @Mock
    private IRemoveAllCustomersUseCase removeCustomerUseCase;

    private RemoveAllCustomersController removeCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        removeCustomerController = new RemoveAllCustomersController(removeCustomerUseCase);
    }

    @Test
    void shouldInvokeRemoveAllCustomersUseCase() {
        // Act
        removeCustomerController.invoke();
        verify(removeCustomerUseCase, times(1)).invoke();
    }
}
