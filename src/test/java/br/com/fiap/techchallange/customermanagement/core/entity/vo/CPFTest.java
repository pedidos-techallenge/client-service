package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CPFTest {
    @Test
    @DisplayName("Deve cadastrar um CPF com valores válidos")
    void shouldRegisterCPFWithValidValues() {
        // Arrange & Act
        CPF cpf = new CPF("12345678900");

        // Assert
        assertEquals("12345678900", cpf.getCpfValue());
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF com valores inválidos")
    void shouldNotRegisterCPFWithInvalidValues() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF("1234567890@")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF com string vazia")
    void shouldNotRegisterCPFWithoutValue() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF("")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF com mais de 11 dígitos")
    void shouldNotRegisterCPFBiggerThan20Digits() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF("12345678945612312314568")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF nulo")
    void shouldNotRegisterNullCPF() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF(null)
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF só de mesmos números")
    void shouldNotRegisterCPFWithAllNumbersEqual() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF("00000000000")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar um CPF com letras")
    void shouldNotRegisterCPFWithLetters() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CPF("1b34567890a")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }
}
