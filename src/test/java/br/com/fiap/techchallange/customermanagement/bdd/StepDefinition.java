package br.com.fiap.techchallenge.customermanagement.bdd;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class StepDefinition {

    private String cpf;
    private String nome;
    private String email;
    private ResponseEntity<String> response;

    @Dado("que os campos CPF, NOME e EMAIL estejam preenchidos corretamente")
    public void queOsCamposEstejamPreenchidosCorretamente() {
        cpf = "12345678900";
        nome = "João Silva";
        email = "joao.silva@email.com";
    }

    @Quando("eu enviar uma requisição POST para o endpoint de cadastro de cliente")
    public void euEnviarUmaRequisicaoPOSTParaOEndpointDeCadastroDeCliente() {
        String jsonBody = String.format("{\"cpf\": \"%s\", \"nome\": \"%s\", \"email\": \"%s\"}", cpf, nome, email);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        // Envia a requisição POST para o endpoint do serviço
        String url = "http://localhost:8080/v1/customers"; // Altere a URL conforme necessário
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

    @Entao("devo obter o resultado 'Cliente cadastrado com sucesso!'")
    public void devoObterOResultado() {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        // Valida se o resultado da resposta contém a mensagem esperada
        assertEquals("Cliente cadastrado com sucesso!", response.getBody());
    }
}