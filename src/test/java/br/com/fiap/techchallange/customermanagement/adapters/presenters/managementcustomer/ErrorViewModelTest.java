package br.com.fiap.techchallange.customermanagement.adapters.presenters.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.ErrorViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorViewModelTest {
    @Test
    void shouldReturnErrorViewModel() {
        ErrorViewModel errorViewModel = new ErrorViewModel(400, "Bad Request");

        assertEquals(errorViewModel.code(), 400);
        assertEquals(errorViewModel.message(), "Bad Request");
    }
}
