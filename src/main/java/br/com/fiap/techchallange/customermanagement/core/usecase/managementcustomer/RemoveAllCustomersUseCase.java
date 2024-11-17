package br.com.fiap.techchallange.customermanagement.core.usecase.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.gateways.repository.ICustomerRepository;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemoveAllCustomersUseCase;

public class RemoveAllCustomersUseCase implements IRemoveAllCustomersUseCase {
    private final ICustomerRepository repository;

    public RemoveAllCustomersUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public void invoke()  {
        this.repository.removeAll();
    }
}
