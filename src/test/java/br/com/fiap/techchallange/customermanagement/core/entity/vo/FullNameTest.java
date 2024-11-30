package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullNameTest {
    @Test
    @DisplayName("Deve cadastrar nome completo com valores válidos")
    void shouldRegisterFullNameWithValidValues() {
        // Arrange & Act
        FullName fullName = new FullName("João das Dores");

        // Assert
        assertEquals("João das Dores", fullName.getFullName());
    }
}
