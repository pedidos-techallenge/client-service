package br.com.fiap.techchallange.customermanagement.adapters.presenters.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.ChangingCustomerController;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerPresenterTest {
    @Test
    void shouldReturnCustomerViewModel() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "john.doe@example.com";
        OutputDataCustomerDTO customerDTO = new OutputDataCustomerDTO(cpf, name, email);

        CustomerPresenterJson presenter = new CustomerPresenterJson();

        // Act
        CustomerViewModel result = presenter.invoke(customerDTO);

        // Assert
        assertNotNull(result);
        assertEquals("123.456.789-00", result.cpf());
        assertEquals(name, result.name());
        assertEquals(email, result.email());
    }
}
