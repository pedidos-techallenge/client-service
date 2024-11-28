package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import org.checkerframework.checker.units.qual.N;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {
    @Test
    @DisplayName("Deve cadastrar nome com valores válidos")
    void shouldRegisterNameWithValidValues() {
        // Arrange & Act
        Name name = new Name("João");

        // Assert
        assertEquals("João", name.getNameValue());
    }

    @Test
    @DisplayName("Não deve cadastrar nome com caractere especial")
    void shouldNotRegisterNameWithSpecialCharacter() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Name("João das Dores****")
        );

        assertEquals(
                "Nome é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar nome com número")
    void shouldNotRegisterNameWithAnyNumber() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Name("João das 123456")
        );

        assertEquals(
                "Nome é inválido!",
                exception.getMessage()
        );
    }
}
