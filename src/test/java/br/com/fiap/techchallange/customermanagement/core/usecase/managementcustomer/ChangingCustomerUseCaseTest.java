package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.ChangingCustomerController;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
}
