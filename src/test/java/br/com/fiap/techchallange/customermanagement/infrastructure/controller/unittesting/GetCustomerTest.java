package br.com.fiap.techchallange.customermanagement.infrastructure.controller.unittesting;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;
import br.com.fiap.techchallange.customermanagement.infrastructure.api.ManagementCustomer;
import br.com.fiap.techchallange.customermanagement.util.CustomerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetCustomerTest {

    MockMvc mockMvc;

    AutoCloseable openMocks;

    @Mock
    IRegisterCustomerController registerCustomerController;

    @Mock
    IGetCustomerController getCustomerController;

    @Mock
    ICustomerPresenter customerPresenterJson;

    @Mock
    IChangingCustomerController changingController;

    @Mock
    IRemovalOfCustomerController removeController;

    @Mock
    IRemoveAllCustomersController removeAllController;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        ManagementCustomer managementCustomer = new ManagementCustomer(registerCustomerController, getCustomerController,
                customerPresenterJson, changingController, removeController, removeAllController);
        mockMvc = MockMvcBuilders.standaloneSetup(managementCustomer)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception{
        openMocks.close();
    }

    @Nested
    public class GerenciamentoCLiente{

        @Test
        public void deveBuscarCliente() throws Exception {
            // GIVEN
            InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678905", "Moisés Monte", "moises.moises@gmail.com");
            OutputDataCustomerDTO outputDataCustomerDTO = new OutputDataCustomerDTO("12345678905", "Moisés Monte", "moises.moises@gmail.com");

            CustomerViewModel customerViewModel = new CustomerViewModel(
                    "12345678905",
                    "Moisés Monte",
                    "moises.moises@gmail.com"
            );

            when(getCustomerController.invoke(inputDataCustomerDTO.cpf()))
                    .thenReturn(outputDataCustomerDTO);

            when(customerPresenterJson.invoke(outputDataCustomerDTO))
                    .thenReturn(customerViewModel);

            // WHEN
            mockMvc.perform(get("/v1/customers/" + inputDataCustomerDTO.cpf())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(CustomerUtil.asJsonString(inputDataCustomerDTO)))
                    .andExpect(status().isOk());

            // THEN
            verify(customerPresenterJson, times(1)).invoke(outputDataCustomerDTO);

        }
    }
}

