package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.managementcustomer.CustomerPresenterJson;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCustomerUseCaseTest {

    @Mock
    ICustomerRepository repository;

    GetCustomerUseCase getCustomerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getCustomerUseCase = new GetCustomerUseCase(repository);
    }

    @Test
    void shouldGetCustomerByCPF() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@email.com";

        InputDataCustomerDTO inputDataCustomerDTO = new InputDataCustomerDTO(cpf, name, email);
        Customer customer = new Customer(cpf, name, email);
        OutputDataCustomerDTO expectedOutput = new OutputDataCustomerDTO(cpf, name, email);

        // Configuração do mock para retornar o cliente esperado
        when(repository.getCustomer(cpf)).thenReturn(customer);

        // Act
        OutputDataCustomerDTO result = getCustomerUseCase.get(inputDataCustomerDTO);

        // Assert
        // Verifica se o método do repositório foi chamado com o CPF correto
        verify(repository, times(1)).getCustomer(cpf);

        // Valida os dados retornados
        assertEquals(expectedOutput.cpf(), result.cpf());
        assertEquals(expectedOutput.name(), result.name());
        assertEquals(expectedOutput.email(), result.email());
    }

}