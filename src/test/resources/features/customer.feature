# Created by ingrid at 11/11/24
# language: pt

Funcionalidade: Cadastro de cliente

    Cenário: Cadastro de cliente com sucesso
        Dado que eu envie uma requisição POST para o endpoint de cadastro de cliente com os campos CPF, NOME e EMAIL preenchidos corretamente
        Quando submeter o cadastro
        Então devo obter o resultado "Cliente cadastrado com sucesso!"

Funcionalidade: Atualização de cliente

    Cenário: Atualização de cliente
        Dado que eu envie uma requisição PUT para o endpoint de atualização de cliente com os campos CPF, NOME e EMAIL preenchidos corretamente
        Quando submeter o a atualização
        Então devo obter o resultado "Cliente atualizado com sucesso!"

Funcionalidade: Busca de cliente

    Cenário: Busca de cliente
        Dado que eu envie uma requisição GET para o endpoint de busca de cliente, usando o CPF como parâmetro de busca
        Quando submeter a requisição
        Então devo receber os dados do cliente e status 200 indicando sucesso

Funcionalidade: Remoção de cliente

    Cenário: Remoção de cliente
        Dado que eu envie uma requisição DELETE para o endpoint de remoção de cliente, usando CPF como parâmetro
        Quando submeter a requisição
        Então devo obter o resultado "Dados do cliente removido com sucesso."