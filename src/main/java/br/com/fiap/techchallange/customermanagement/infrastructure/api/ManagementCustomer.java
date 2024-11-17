package br.com.fiap.techchallange.customermanagement.infrastructure.api;

import br.com.fiap.techchallange.customermanagement.adapters.controllers.managementcustomer.*;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.customermanagement.adapters.presenters.viewmodel.ErrorViewModel;
import br.com.fiap.techchallange.customermanagement.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.customermanagement.infrastructure.dto.ClientRequestDTO;

import br.com.fiap.techchallange.customermanagement.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
@Tag(name = "1. Management Customer", description = "Endpoints para a gestão do cadastro do cliente")
public class ManagementCustomer  {
    IRegisterCustomerController registerCustomerController;
    IGetCustomerController getController;
    IChangingCustomerController changingCustomerController;
    IRemovalOfCustomerController removeCustomerController;
    ICustomerPresenter customerPresenterJson;
    IRemoveAllCustomersController removeAllCustomersController;

    public ManagementCustomer(IRegisterCustomerController registerController,
                              IGetCustomerController getController,
                              ICustomerPresenter customerPresenterJson,
                              IChangingCustomerController changingController,
                              IRemovalOfCustomerController removeController,
                              IRemoveAllCustomersController removeAllController
                              ){
        this.registerCustomerController = registerController;
        this.getController = getController;
        this.changingCustomerController = changingController;
        this.removeCustomerController = removeController;
        this.removeAllCustomersController = removeAllController;
        this.customerPresenterJson = customerPresenterJson;
    }

    @Operation(summary = "Registrar as informações do cliente.")
    @PostMapping("/")
    public ResponseEntity<?> registerCustomer(@RequestBody ClientRequestDTO clientDeserializer) throws DataAccessException {
        try {
            this.registerCustomerController.invoke(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(3,"CPF já cadastrado na base de dados!"), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorViewModel(99, e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( "Cliente cadastrado com sucesso!", HttpStatus.OK);
    }

    @Operation(summary = "Busca as informações do cliente.")
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getCustomer(@PathVariable String cpf) throws EmptyResultDataAccessException {
        try {
            CustomerViewModel response = customerPresenterJson.invoke(this.getController.invoke(cpf));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(4,"Cliente não encontrado na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Atualiza as informações do cliente.")
    @PutMapping("/")
    public ResponseEntity<?> changingCustomer(@RequestBody ClientRequestDTO clientDeserializer) throws DataAccessException {
        try {
            this.changingCustomerController.invoke(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(5,"Houve um problema na atualização das informações do cliente"), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorViewModel(99, e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( "Cliente atualizado com sucesso!", HttpStatus.OK);
    }

    @Operation(summary = "Remove as informações do cliente.!")
    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> removeCustomer(@PathVariable String cpf) throws EmptyResultDataAccessException {
        try {
            this.removeCustomerController.invoke(cpf);
            return new ResponseEntity<>("Dados do cliente removidos com sucesso!", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(6,"Houve um problema na remoção das informações do cliente."), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Remove todos os clientes da base de dados.")
    @DeleteMapping("/")
    public ResponseEntity<?> removeAllCustomers() throws EmptyResultDataAccessException {
        try {
            this.removeAllCustomersController.invoke();
            return new ResponseEntity<>("Todos os clientes foram removidos com sucesso!", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(6,"Houve um problema na remoção das informações dos clientes."), HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorViewModel> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorViewModel error = new ErrorViewModel(4, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
