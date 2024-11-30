package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {
    @Test
    @DisplayName("Deve cadastrar um email com valores válidos")
    void shouldRegisterEmailWithValidValues() {
        // Arrange & Act
        Email email = new Email("meu@mail.com");

        // Assert
        assertEquals("meu@mail.com", email.getEmailValue());
    }

    @Test
    @DisplayName("Não deve cadastrar um email sem arroba")
    void shouldNotRegisterEmailWithoutAtSign() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Email("meuemail.com")
        );

        assertEquals(
                "Email é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um email sem ponto com no final")
    void shouldNotRegisterEmailWithoutDotCom() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Email("meuemail@com")
        );

        assertEquals(
                "Email é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um email com arroba no início")
    void shouldNotRegisterEmailWhichStartsWitchAtSign() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Email("@meuemail.com")
        );

        assertEquals(
                "Email é inválido!",
                exception.getMessage()
        );
    }
}
