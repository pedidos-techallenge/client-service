package br.com.fiap.techchallange.customermanagement.infrastructure.dto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ClientRequestDTOTest {

    @Test
    void shouldCreateClientRequestDTOWithCorrectValues() {
        // Arrange
        String cpf = "12345678900";
        String name = "José Arlindo";
        String email = "jose.arlindo@email.com";

        // Act
        ClientRequestDTO dto = new ClientRequestDTO(cpf, name, email);

        // Assert
        assertEquals(cpf, dto.cpf());
        assertEquals(name, dto.name());
        assertEquals(email, dto.email());
    }
}