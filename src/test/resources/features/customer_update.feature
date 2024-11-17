# Created by ingrid at 11/11/24
# language: pt

Funcionalidade: Atualização de cliente

  Cenario: Atualização de cliente
  Dado que os campos CPF, NOME e EMAIL estejam preenchidos corretamente para atualização de cliente
  Quando eu enviar uma requisição PUT para o endpoint de atualização de cliente
  Entao devo obter o resultado Cliente atualizado com sucesso!