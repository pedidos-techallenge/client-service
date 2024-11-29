package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovalOfCustomerUseCaseTest {
    @Mock
    IRemovalOfCustomerUseCase iRemovalOfCustomerUseCase;

    @Mock
    ICustomerRepository repository;

    RemovalOfCustomerUseCase removalOfCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        removalOfCustomerUseCase = new RemovalOfCustomerUseCase(repository);
    }

    @Test
    void shouldRemovalOfCustomer() {
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@email.com";

        InputDataCustomerDTO inputDataCustomerDTO = new InputDataCustomerDTO(cpf, name, email);

        // Act
        removalOfCustomerUseCase.invoke(inputDataCustomerDTO);

        // Assert
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(repository, times(1)).remove(captor.capture());

        String cpfCaptured = captor.getValue();
        assertEquals(cpf, cpfCaptured);
    }

}
