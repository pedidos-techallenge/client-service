# Created by ingrid at 11/11/24
# language: pt

Funcionalidade: Cadastro de cliente

    Cenario: Cadastro de cliente com sucesso
        Dado que os campos CPF, NOME e EMAIL estejam preenchidos corretamente
        Quando eu enviar uma requisição POST para o endpoint de cadastro de cliente
        Entao devo obter o resultado "Cliente cadastrado com sucesso!"