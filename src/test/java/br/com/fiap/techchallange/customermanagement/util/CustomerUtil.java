package br.com.fiap.techchallange.customermanagement.util;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerUtil {
    public static InputDataCustomerDTO generateCustomer(String cpf, String name, String email) {
        return new InputDataCustomerDTO(cpf, name, email);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
