package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;

public class ChangingCustomerController implements IChangingCustomerController {

    IChangingCustomerUseCase changingCustomerUserCase;

    public ChangingCustomerController(IChangingCustomerUseCase commandUserCase){
        this.changingCustomerUserCase = commandUserCase;
    }

    public void invoke(String cpf, String name, String email) {
        changingCustomerUserCase.invoke(new InputDataCustomerDTO(cpf, name, email));
    }
}
