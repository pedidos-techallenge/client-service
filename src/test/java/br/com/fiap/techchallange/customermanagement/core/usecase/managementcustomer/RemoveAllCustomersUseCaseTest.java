package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemoveAllCustomersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RemoveAllCustomersUseCaseTest {
    @Mock
    IRemoveAllCustomersUseCase iRemoveAllCustomersUseCase;

    @Mock
    ICustomerRepository repository;

    RemoveAllCustomersUseCase removeAllCustomersUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        removeAllCustomersUseCase = new RemoveAllCustomersUseCase(repository);
    }

    @Test
    void shouldRemoveAllCustomers() {
        removeAllCustomersUseCase.invoke();
        verify(repository, times(1)).removeAll();
    }
}
