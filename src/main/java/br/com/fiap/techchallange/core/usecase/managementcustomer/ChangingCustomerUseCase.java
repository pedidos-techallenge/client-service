package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class ChangingCustomerUseCase implements IChangingCustomerUseCase {

    private final ICustomerRepository repository;

    public ChangingCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(InputDataCustomerDTO customerDTO) throws IllegalArgumentException {
        this.repository.changing(new Customer(customerDTO.cpf(), customerDTO.name(), customerDTO.email()));
    }
}
