package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.ChangingCustomerController;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangingCustomerUseCaseTest {
    @Mock
    IChangingCustomerUseCase iChangingCustomerUseCase;

    @Mock
    ICustomerRepository repository;

    ChangingCustomerUseCase changingCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        changingCustomerUseCase = new ChangingCustomerUseCase(repository);
    }

    @Test
    void shouldChangeCustomer() {
        InputDataCustomerDTO customerDTO = new InputDataCustomerDTO("12345678900", "José Arlindo", "jose.arlindo@email.com");
        iChangingCustomerUseCase.invoke(customerDTO);

        ArgumentCaptor<InputDataCustomerDTO> captor = ArgumentCaptor.forClass(InputDataCustomerDTO.class);
        verify(iChangingCustomerUseCase, times(1)).invoke(captor.capture());

        assertEquals(customerDTO.cpf(), captor.getValue().cpf());
    }

    @Test
    void shouldChangingCustomerWithRealRepository() {
        InputDataCustomerDTO customerDTO = new InputDataCustomerDTO("12345678900", "José Arlindo", "jose.arlindo@email.com");

        // Act
        changingCustomerUseCase.invoke(customerDTO);

        // Assert
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(repository, times(1)).changing(captor.capture());
        assertEquals("12345678900", captor.getValue().getCPF());
        assertEquals("José Arlindo", captor.getValue().getName());
        assertEquals("jose.arlindo@email.com", captor.getValue().getEmail());
    }
}
