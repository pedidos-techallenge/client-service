package br.com.fiap.techchallange.customermanagement.infrastructure.config.presenters.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerPresenterConfigTest {
    @Test
    void shouldGetCustomerPresenter() {
        CustomerPresenterConfig customerPresenterConfig = new CustomerPresenterConfig();
        Object iCustomerPresenter = customerPresenterConfig.getCustomerPresenter();
        assertThat(iCustomerPresenter).isInstanceOf(ICustomerPresenter.class);
    }
}