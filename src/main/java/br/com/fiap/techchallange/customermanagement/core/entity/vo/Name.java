package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import java.util.InputMismatchException;

public class Name {
    private String nameValue;

    public Name(String name) {
        this.checkNameValue(name);
    }

    public String getNameValue() {
        return this.nameValue;
    }

    public void checkNameValue(String name) throws InputMismatchException {

        boolean hasSpecialCharacter = isSpecialCharacter(name);
        if (name.matches(".*\\d.*") || hasSpecialCharacter) {
            throw new IllegalArgumentException("Nome é inválido!");
        } else {
            this.nameValue = name;
        }
    }

    public boolean isSpecialCharacter(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c) || ((!Character.isLetter(c) && c != ' '))){
                return true;
            }
        }
        return false;
    }
}
