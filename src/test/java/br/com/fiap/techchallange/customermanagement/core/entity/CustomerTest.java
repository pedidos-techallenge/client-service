package br.com.fiap.techchallange.customermanagement.core.entity;

import br.com.fiap.techchallange.customermanagement.core.entity.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {
    @Test
    @DisplayName("Deve cadastrar cliente com valores válidos")
    void shouldRegisterCustomerWithValidValues() {
        // Arrange & Act
        Customer customer = new Customer("12345678900", "João das Dores", "joaodasdores@email.com");

        // Assert
        assertEquals("12345678900", customer.getCPF());
        assertEquals("João das Dores", customer.getName());
        assertEquals("joaodasdores@email.com", customer.getEmail());
    }

    @Test
    @DisplayName("Não deve cadastrar cliente com CPF inválido")
    void shouldNotRegisterCustomerWithInvalidCPF() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Customer("123457890@", "João das Dores", "joaodasdores@email.com")
        );

        assertEquals(
                "CPF é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar cliente com nome inválido")
    void shouldNotRegisterCustomerWithInvalidName() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Customer("12345678910", "João das 1", "joaodasdores@email.com")
        );

        assertEquals(
                "Nome é inválido!",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Não deve cadastrar cliente com email inválido")
    void shouldNotRegisterCustomerWithInvalidEmail() {
        // Assert
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Customer("12345678910", "João das Dores", "@joaodasdores@email.com")
        );

        assertEquals(
                "Email é inválido!",
                exception.getMessage()
        );
    }
}
