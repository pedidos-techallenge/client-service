package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;

public class RemovalOfCustomerUseCase implements IRemovalOfCustomerUseCase {

    private final ICustomerRepository repository;

    public RemovalOfCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public void invoke(InputDataCustomerDTO inputDataCustomerDTODTO) {
            this.repository.remove(inputDataCustomerDTODTO.cpf());
    }
}