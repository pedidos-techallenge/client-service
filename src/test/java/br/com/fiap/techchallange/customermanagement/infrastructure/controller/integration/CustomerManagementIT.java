package br.com.fiap.techchallange.customermanagement.infrastructure.controller.integration;

import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.infrastructure.bd.MySQLCustomerRepository;
import br.com.fiap.techchallange.customermanagement.util.CustomerUtil;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class CustomerManagementIT {

    @LocalServerPort
    private int port;

    @Autowired
    MySQLCustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Populate the database
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("12345678900", "José Arlindo", "jose@arlindo.com");
        Customer customer2 = new Customer("12345678901", "Maria Joana", "maria@joana.com");
        Customer customer3 = new Customer("12345678902", "João Francisco", "joao@francisco.com");
        Customer customer4 = new Customer("12345678903", "Ana Luiza", "ana@luiza.com");
        Customer customer5 = new Customer("12345678904", "Ney Mar", "ney@mar.com");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        for (Customer customer : customers) {
            customerRepository.register(customer);
        }
    }

    @AfterEach
    public void down() {
        customerRepository.removeAll();
    }

    @Nested
    public class GerenciamentoCLiente{
        @Test
        public void deveCadastrarCliente(){
            InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678905", "Moisés Monte", "moises.moises@gmail.com");

            given()
                .header("Content-Type", "application/json")
                .body(inputDataCustomerDTO)
                .when()
                .post("/v1/customers/")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType("text/plain")
                .body(equalTo("Cliente cadastrado com sucesso!"));
        }
    }

    @Test
    public void deveAtualizarCliente(){
        InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678900", "José Arlindo Atualizado", "jose.arlindo@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .body(inputDataCustomerDTO)
                .when()
                .put("/v1/customers/")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType("text/plain")
                .body(equalTo("Cliente atualizado com sucesso!"));
    }

    @Test
    public void deveRemoverCliente(){
        InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678900", "José Arlindo Atualizado", "jose.arlindo@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/v1/customers/" + inputDataCustomerDTO.cpf())
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType("text/plain")
                .body(equalTo("Dados do cliente removidos com sucesso!"));
    }

    @Test
    public void deveBuscarCliente(){
        InputDataCustomerDTO inputDataCustomerDTO = CustomerUtil.generateCustomer("12345678900","José Arlindo", "jose@arlindo.com");
        OutputDataCustomerDTO outputDataCustomerDTO = new OutputDataCustomerDTO("12345678900","José Arlindo", "jose@arlindo.com");
        given()
                .header("Content-Type", "application/json")
                .body(inputDataCustomerDTO)
                .when()
                .get("/v1/customers/" + inputDataCustomerDTO.cpf())
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType("application/json") // Atualizado para JSON
                .body("cpf", equalTo(outputDataCustomerDTO.cpf())) // Validação do JSON retornado
                .body("name", equalTo(outputDataCustomerDTO.name()))
                .body("email", equalTo(outputDataCustomerDTO.email()));
    }

    @Test
    public void deveRemoverTodosOsClientes(){

        given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/v1/customers/")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType("text/plain")
                .body(equalTo("Todos os clientes foram removidos com sucesso!"));
    }
}
