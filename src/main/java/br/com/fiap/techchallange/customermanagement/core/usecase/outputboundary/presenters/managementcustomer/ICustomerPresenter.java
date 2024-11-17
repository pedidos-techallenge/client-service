package br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer;

import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.customermanagement.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface ICustomerPresenter {
    CustomerViewModel invoke(OutputDataCustomerDTO customerDTO);
}
