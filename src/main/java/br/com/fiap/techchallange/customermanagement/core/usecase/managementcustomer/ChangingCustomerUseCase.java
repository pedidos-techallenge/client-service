package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;

public class ChangingCustomerUseCase implements IChangingCustomerUseCase {

    private final ICustomerRepository repository;

    public ChangingCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(InputDataCustomerDTO customerDTO) throws IllegalArgumentException {
        this.repository.changing(new Customer(customerDTO.cpf(), customerDTO.name(), customerDTO.email()));
    }
}
