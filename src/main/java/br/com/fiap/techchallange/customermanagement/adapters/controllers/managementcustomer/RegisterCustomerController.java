package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUseCase;

public class RegisterCustomerController implements IRegisterCustomerController {

    IRegisteringCustomerUseCase registeringCustomerUserCase;

    public RegisterCustomerController(IRegisteringCustomerUseCase commandUserCase){
        this.registeringCustomerUserCase = commandUserCase;
    }

    public void invoke(String cpf, String name, String email) {
        registeringCustomerUserCase.invoke(new InputDataCustomerDTO(cpf, name, email));
    }

}
