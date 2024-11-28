package br.com.fiap.techchallange.customermanagement.infrastructure.bd;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySQLCustomerRepositoryTest {
    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MySQLCustomerRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repository = new MySQLCustomerRepository(jdbcTemplate);
    }

    @Test
    void shouldRegisterCustomerInDatabase() {
        // Arrange
        Customer customer = new Customer("12345678900", "José Arlindo", "jose.arlindo@email.com");

        // Act
        repository.register(customer);

        // Assert
        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);

        verify(jdbcTemplate, times(1)).update(sqlCaptor.capture(), paramsCaptor.capture());

        // Verifica a query SQL
        assertEquals("INSERT into dbtechchallange.customer (cpf, name, email) VALUES (:cpf, :name, :email)", sqlCaptor.getValue());

        // Verifica os parâmetros
        MapSqlParameterSource capturedParams = paramsCaptor.getValue();
        assertEquals("12345678900", capturedParams.getValue("cpf"));
        assertEquals("José Arlindo", capturedParams.getValue("name"));
        assertEquals("jose.arlindo@email.com", capturedParams.getValue("email"));
}

    @Test
    void shouldReturnCustomerWhenFoundInDatabase() {
        // Arrange
        String cpf = "12345678900";
        Customer expectedCustomer = new Customer(cpf, "John Doe", "john.doe@example.com");

        when(jdbcTemplate.queryForObject(
                eq("SELECT * FROM dbtechchallange.customer where cpf = :cpf"),
                any(MapSqlParameterSource.class),
                any(RowMapper.class))
        ).thenReturn(expectedCustomer);

        // Act
        Customer result = repository.getCustomer(cpf);

        // Assert
        assertEquals(expectedCustomer.getCPF(), result.getCPF());
        assertEquals(expectedCustomer.getName(), result.getName());
        assertEquals(expectedCustomer.getEmail(), result.getEmail());
    }
}
