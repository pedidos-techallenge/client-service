package br.com.fiap.techchallange.customermanagement.bdd;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.util.CustomerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.AfterAll;
import org.springframework.test.context.ActiveProfiles;
import static io.restassured.RestAssured.given;

@ActiveProfiles("test")
public class StepDefinition {

    private Response response;

    private InputDataCustomerDTO existingCustomerDTO;
    private static String CUSTOMERS_URL = "http://localhost:8080/v1/customers/";

    @Before
    public void setup() {
        // Set customer to be used in all tests (except the Register Test)
        String cpf = "12345678900";
        String name = "Maria das Dores";
        String email = "mariadasdores@email.com";

        existingCustomerDTO = CustomerUtil.generateCustomer(cpf, name, email);
        response = given()
            .header("Content-Type", "application/json")
            .body(existingCustomerDTO)
            .when()
            .post(CUSTOMERS_URL);
    }

    @After
    public static void cleanDatabase() {
        Response response = given()
            .header("Content-Type", "application/json")
            .when()
            .delete(CUSTOMERS_URL);
    }

    // Scenario 1
    @Dado("que os campos CPF, NOME e EMAIL estejam preenchidos corretamente")
    public void queOsCamposEstejamPreenchidosCorretamente() {
        String cpf = "12345678901";
        String name = "João Silva";
        String email = "joao.silva@email.com";
    }

    @Quando("eu enviar uma requisição POST para o endpoint de cadastro de cliente")
    public void euEnviarUmaRequisicaoPOSTParaOEndpointDeCadastroDeCliente() {
        String cpf = "12345678901";
        String name = "João Silva";
        String email = "joao.silva@email.com";

        InputDataCustomerDTO inputDataCustomerDTO;
        // Send request
        inputDataCustomerDTO = CustomerUtil.generateCustomer(cpf, name, email);
        response = given()
                .header("Content-Type", "application/json")
                .body(inputDataCustomerDTO)
                .when()
                .post(CUSTOMERS_URL);
    }

    @Entao("devo obter o resultado Cliente cadastrado com sucesso!")
    public void devoObterOResultado() {
        assertEquals("Cliente cadastrado com sucesso!", response.getBody().print());
    }

    // Scenario 2
    @Dado("que o campo CPF esteja preenchido corretamente como parâmetro de busca")
    public void queOCampoCPFEstejaPreenchidoCorretamente() {
        String cpf = existingCustomerDTO.cpf();
    }

    @Quando("eu enviar uma requisição GET para o endpoint de busca de cliente")
    public void euEnviarUmaRequisicaoGetParaOEndpointDeBuscaDeCliente() {
        String cpf = existingCustomerDTO.cpf();
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(CUSTOMERS_URL + cpf);
    }

    @Entao("devo receber os dados do cliente e status {int} indicando sucesso")
    public void devoReceberOsDadosDoClienteEStatus200(int expectedStatus) {
        ResponseBody body = response.body();

        // Check if the fields exist
        String cpf = body.jsonPath().getString("cpf");
        String name = body.jsonPath().getString("name");
        String email = body.jsonPath().getString("email");

        // Check if the fields are not null
        assertNotNull(cpf, "O campo 'cpf' está ausente ou é nulo.");
        assertNotNull(name, "O campo 'name' está ausente ou é nulo.");
        assertNotNull(email, "O campo 'email' está ausente ou é nulo.");

        // Check if the fields are not empty
        assertFalse(cpf.isEmpty(), "O campo 'cpf' está vazio.");
        assertFalse(name.isEmpty(), "O campo 'name' está vazio.");
        assertFalse(email.isEmpty(), "O campo 'email' está vazio.");

        // Check if status code is as expected (200)
        assertEquals(expectedStatus, response.statusCode());
    }

    // Scenario 3
    @Dado("que os campos CPF, NOME e EMAIL estejam preenchidos corretamente para atualização de cliente")
    public void queOsCamposEstejamPreenchidosCorretamenteParaAtualizacaoDeCliente() {
        String cpf = existingCustomerDTO.cpf();
        String name = existingCustomerDTO.name();
        String email = existingCustomerDTO.email();
    }

    @Quando("eu enviar uma requisição PUT para o endpoint de atualização de cliente")
    public void euEnviarUmaRequisicaoParaOEndpointDeAtualizacaoDeCliente() {
        InputDataCustomerDTO updatedCustomer = CustomerUtil.generateCustomer(existingCustomerDTO.cpf(), "Ana Maria das Dores", "anamaria.dasdores@email.com");
        response = given()
                .header("Content-Type", "application/json")
                .body(updatedCustomer)
                .when()
                .put(CUSTOMERS_URL);
    }

    @Entao("devo obter o resultado Cliente atualizado com sucesso!")
    public void devoObterOResultadoClienteAtualizadoComSucesso() {
        assertEquals("Cliente atualizado com sucesso!", response.getBody().print());
    }

    // Scenario 4
    @Dado("que o campo CPF esteja preenchido corretamente como parâmetro de busca para remoção de cliente")
    public void queOCampoCPFEstejaPreenchidoCorretamenteParaRemocaoDeCliente() {
        String cpf = existingCustomerDTO.cpf();
    }

    @Quando("eu enviar uma requisição DELETE para o endpoint de remoção de cliente")
    public void euEnviarUmaRequisicaoDeleteParaOEndpointDeRemocaoDeCliente() {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete(CUSTOMERS_URL + existingCustomerDTO.cpf());
    }

    @Entao("devo obter o resultado Dados do cliente removidos com sucesso!")
    public void devoBoterOResultadoDadosDoClienteRemovidosComSucesso() {
        assertEquals("Dados do cliente removidos com sucesso!", response.getBody().print());
    }
}