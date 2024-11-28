package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RegisterCustomerControllerTest {
    @Mock
    private IRegisteringCustomerUseCase registerCustomerUseCase;

    private RegisterCustomerController registerCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registerCustomerController = new RegisterCustomerController(registerCustomerUseCase);
    }

    @Test
    void shouldInvokeRegisterCustomerUseCaseWithCorrectParameters() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@gmail.com";

        // Act
        registerCustomerController.invoke(cpf, name, email);

        // Assert
        ArgumentCaptor<InputDataCustomerDTO> captor = ArgumentCaptor.forClass(InputDataCustomerDTO.class);
        verify(registerCustomerUseCase, times(1)).invoke(captor.capture());

        InputDataCustomerDTO capturedArgument = captor.getValue();
        assertEquals(cpf, capturedArgument.cpf());
        assertEquals(name, capturedArgument.name());
        assertEquals(email, capturedArgument.email());
    }
}
