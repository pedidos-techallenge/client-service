package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUseCase;
import io.cucumber.java.sl.In;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterCustomerUseCaseTest {

    @Mock
    IRegisteringCustomerUseCase iRegisterCustomerUseCase;

    @Mock
    ICustomerRepository repository;

    RegisteringCustomerUseCase registerCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registerCustomerUseCase = new RegisteringCustomerUseCase(repository);
    }

    @Test
    void shouldRegisterCustomerWithCorrectParameters() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@email.com";

        InputDataCustomerDTO inputDataCustomerDTO = new InputDataCustomerDTO(cpf, name, email);

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);

        // Act
        registerCustomerUseCase.invoke(inputDataCustomerDTO);

        // Assert
        verify(repository, times(1)).register(captor.capture());
        Customer capturedCustomer = captor.getValue();

        assertEquals(cpf, capturedCustomer.getCPF());
        assertEquals(name, capturedCustomer.getName());
        assertEquals(email, capturedCustomer.getEmail());
    }
}
