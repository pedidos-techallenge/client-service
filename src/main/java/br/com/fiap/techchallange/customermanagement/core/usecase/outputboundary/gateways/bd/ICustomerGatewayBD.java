package br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.gateways.bd;

import br.com.fiap.techchallange.customermanagement.core.entity.Customer;

public interface ICustomerGatewayBD {

    public Customer getCustomer(String cpf);
    public void register(Customer customer);
    public void changing(Customer customer);
    public void remove(String cpf);
}
