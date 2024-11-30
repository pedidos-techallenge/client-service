package br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.customermanagement.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;

public class GetCustomerController implements IGetCustomerController {

    IGetCustomerUseCase getCustomerUserCase;

    public GetCustomerController(IGetCustomerUseCase queryUserCase){
        this.getCustomerUserCase = queryUserCase;
    }

    public OutputDataCustomerDTO invoke(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        return getCustomerUserCase.get(inputData);
    }
}
