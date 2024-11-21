package br.com.fiap.techchallange.customermanagement.infrastructure.controller.integration;

import br.com.fiap.techchallange.customermanagement.CustomerManagementApplicationTests;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.util.CustomerUtil;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CustomerManagementApplicationTests.class)
@ActiveProfiles("test")
@Transactional
@SpringJUnitConfig
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class CustomerManagementIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Nested
    public class GerenciamentoCLiente{
        @Test
        public void deveCadastrarCliente(){
            InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678900", "José Arlindo", "jose.arlindo@gmail.com");
            OutputDataCustomerDTO outputDataCustomerDTO = new OutputDataCustomerDTO("12345678900", "José Arlindo", "jose.arlindo@gmail.com");

            given()
                .header("Content-Type", "application/json")
                .body(inputDataCustomerDTO)
                .when()
                .post("/v1/customers/")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("cpf", equalTo(outputDataCustomerDTO.cpf())
                );
        }
    }
}
