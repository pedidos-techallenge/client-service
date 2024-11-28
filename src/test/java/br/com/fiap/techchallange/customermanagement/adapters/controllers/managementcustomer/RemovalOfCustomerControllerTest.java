package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RemovalOfCustomerControllerTest {
    @Mock
    private IRemovalOfCustomerUseCase removeCustomerUseCase;

    private RemovalOfCustomerController removeCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        removeCustomerController = new RemovalOfCustomerController(removeCustomerUseCase);
    }

    @Test
    void shouldInvokeRemovalOfCustomerUseCaseWithCorrectParameters() {
        // Arrange
        String cpf = "12345678900";

        // Act
        removeCustomerController.invoke(cpf);

        // Assert
        ArgumentCaptor<InputDataCustomerDTO> captor = ArgumentCaptor.forClass(InputDataCustomerDTO.class);
        verify(removeCustomerUseCase, times(1)).invoke(captor.capture());

        InputDataCustomerDTO capturedDTO = captor.getValue();
        assertEquals(cpf, capturedDTO.cpf());
    }
}
