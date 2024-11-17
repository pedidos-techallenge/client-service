# Created by ingrid at 11/11/24
# language: pt

Funcionalidade: Remoção de cliente

  Cenario: Remoção de cliente
  Dado que o campo CPF esteja preenchido corretamente como parâmetro de busca para remoção de cliente
  Quando eu enviar uma requisição DELETE para o endpoint de remoção de cliente
  Entao devo obter o resultado Dados do cliente removidos com sucesso!