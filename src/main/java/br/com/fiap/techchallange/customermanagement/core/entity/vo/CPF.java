package br.com.fiap.techchallange.customermanagement.core.entity.vo;

public class CPF {
    private String cpfValue;

    public CPF(String cpfValue) throws IllegalArgumentException {
        this.checkCPFValue(cpfValue);
    }

    public void checkCPFValue(String cpfValue) throws IllegalArgumentException{
        if (cpfValue == null || cpfValue.length() != 11 || !cpfValue.matches("\\d{11}") ||
                cpfValue.matches(".*[a-z].*") ||
                cpfValue.matches("(\\d)\\1{10}")) { // Detecta todos os números iguais
            throw new IllegalArgumentException("CPF é inválido!");
        }
        this.cpfValue = cpfValue;
    }

    public String getCpfValue() {
        return cpfValue;
    }
}
