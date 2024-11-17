package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface IGetCustomerController {
    public OutputDataCustomerDTO invoke(String cpf);
}
