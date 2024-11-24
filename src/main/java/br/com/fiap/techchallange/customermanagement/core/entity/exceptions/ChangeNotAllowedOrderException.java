package br.com.fiap.techchallange.customermanagement.core.entity.exceptions;

public class ChangeNotAllowedOrderException extends RuntimeException {

        public ChangeNotAllowedOrderException(String message) {
            super(message);
        }
}
