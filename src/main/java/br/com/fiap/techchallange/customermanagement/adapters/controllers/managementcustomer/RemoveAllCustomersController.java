package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRemoveAllCustomersUseCase;

public class RemoveAllCustomersController implements IRemoveAllCustomersController {

    IRemoveAllCustomersUseCase removeAllCustomersUseCase;
    public RemoveAllCustomersController(IRemoveAllCustomersUseCase commandUserCase){
        this.removeAllCustomersUseCase = commandUserCase;
    }

    public void invoke() {
        removeAllCustomersUseCase.invoke();
    }
}
