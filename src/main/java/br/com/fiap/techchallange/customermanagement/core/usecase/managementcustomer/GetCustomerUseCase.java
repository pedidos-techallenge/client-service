package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.entity.Customer;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;

public class GetCustomerUseCase implements IGetCustomerUseCase {

    private final ICustomerRepository repository;

    public GetCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public OutputDataCustomerDTO get(InputDataCustomerDTO inputDataCustomer) {
        Customer customer = repository.getCustomer(inputDataCustomer.cpf());
        return new OutputDataCustomerDTO(customer.getCPF(), customer.getName(), customer.getEmail());
    }
}
