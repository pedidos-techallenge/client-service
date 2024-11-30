package br.com.fiap.techchallange.customermanagement.core.entity.vo;

import java.io.Serializable;

public class FullName implements Serializable {

    private String fullName;

    public FullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
