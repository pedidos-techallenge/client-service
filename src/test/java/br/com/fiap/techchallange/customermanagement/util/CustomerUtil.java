package br.com.fiap.techchallange.customermanagement.util;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;

public class CustomerUtil {
    public static InputDataCustomerDTO generateCustomer(String cpf, String name, String email) {
        return new InputDataCustomerDTO(cpf, name, email);
    }
}
