package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUseCase;
import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;

public class RegisteringCustomerUseCase implements IRegisteringCustomerUseCase {

    private final ICustomerRepository repository;

    public RegisteringCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(InputDataCustomerDTO customerDTO) throws IllegalArgumentException {
        this.repository.register(new Customer(customerDTO.cpf(), customerDTO.name(), customerDTO.email()));
    }
}
