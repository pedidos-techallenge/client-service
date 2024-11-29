package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.managementcustomer.CustomerPresenterJson;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
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

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCustomerUseCaseTest {

    @Mock
    IGetCustomerUseCase iGetCustomerUseCase;

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
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@email.com";

        InputDataCustomerDTO inputDataCustomerDTO = new InputDataCustomerDTO(cpf, name, email);
        OutputDataCustomerDTO outputDataCustomerDTO = new OutputDataCustomerDTO(cpf, name, email);

        iGetCustomerUseCase.get(inputDataCustomerDTO);

        when(iGetCustomerUseCase.get(eq(inputDataCustomerDTO))).thenReturn(outputDataCustomerDTO);
        verify(iGetCustomerUseCase, times(1)).get(inputDataCustomerDTO);

        assertEquals("123.456.789-00", outputDataCustomerDTO.cpf());
        assertEquals(inputDataCustomerDTO.name(), outputDataCustomerDTO.name());
        assertEquals(inputDataCustomerDTO.email(), outputDataCustomerDTO.email());
    }
}
