package br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;

public interface IChangingCustomerUseCase {
    public void invoke(InputDataCustomerDTO customerDTO);
}
