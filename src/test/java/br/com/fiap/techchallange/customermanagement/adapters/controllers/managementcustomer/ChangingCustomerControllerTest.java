package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChangingCustomerControllerTest {

    @Mock
    private IChangingCustomerUseCase changingCustomerUseCase;

    private ChangingCustomerController changingCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        changingCustomerController = new ChangingCustomerController(changingCustomerUseCase);
    }

    @Test
    void shouldInvokeChangingCustomerUseCaseWithCorrectParameters() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@gmail.com";

        // Act
        changingCustomerController.invoke(cpf, name, email);

        // Assert
        ArgumentCaptor<InputDataCustomerDTO> captor = ArgumentCaptor.forClass(InputDataCustomerDTO.class);
        verify(changingCustomerUseCase, times(1)).invoke(captor.capture());

        InputDataCustomerDTO capturedArgument = captor.getValue();
        assertEquals(cpf, capturedArgument.cpf());
        assertEquals(name, capturedArgument.name());
        assertEquals(email, capturedArgument.email());
    }
}

