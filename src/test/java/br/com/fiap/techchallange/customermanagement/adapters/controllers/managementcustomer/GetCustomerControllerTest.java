package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetCustomerControllerTest {

    @Mock
    private IGetCustomerUseCase getCustomerUseCase;

    private GetCustomerController getCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getCustomerController = new GetCustomerController(getCustomerUseCase);
    }

    @Test
    void shouldInvokeGetCustomerUseCaseWithCorrectParameters() {
        // Arrange
        String cpf = "12345678900";

        InputDataCustomerDTO customerDTO = new InputDataCustomerDTO(cpf);
        OutputDataCustomerDTO expectedCustomer = new OutputDataCustomerDTO(cpf, "", "");

        // Act
        getCustomerController.invoke(cpf);

        when(getCustomerUseCase.get(eq(customerDTO))).thenReturn(expectedCustomer);
        verify(getCustomerUseCase, times(1)).get(customerDTO);

        //InputDataCustomerDTO customerDTO = captor.getValue();
        assertEquals(cpf, customerDTO.cpf());
    }
}
