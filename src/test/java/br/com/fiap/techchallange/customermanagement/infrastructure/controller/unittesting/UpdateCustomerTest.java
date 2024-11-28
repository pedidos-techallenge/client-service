package br.com.fiap.techchallange.customermanagement.infrastructure.controller.unittesting;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdateCustomerTest {
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
        public void deveAtualizarCliente() throws Exception {
            // GIVEN
            InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678905", "Moisés Monte Aguiar", "moises.moises@gmail.com");

            doNothing().when(changingController).invoke(inputDataCustomerDTO.cpf(), inputDataCustomerDTO.name(), inputDataCustomerDTO.email());

            // WHEN
            mockMvc.perform(put("/v1/customers/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(CustomerUtil.asJsonString(inputDataCustomerDTO)))
                    .andExpect(status().isOk());

            // THEN
            verify(changingController, times(1)).invoke(inputDataCustomerDTO.cpf(), inputDataCustomerDTO.name(), inputDataCustomerDTO.email());

        }
    }
}
