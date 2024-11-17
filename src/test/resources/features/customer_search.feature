# Created by ingrid at 11/11/24
# language: pt

Funcionalidade: Busca de cliente

  Cenario: Busca de cliente
  Dado que o campo CPF esteja preenchido corretamente como parâmetro de busca
  Quando eu enviar uma requisição GET para o endpoint de busca de cliente
  Entao devo receber os dados do cliente e status 200 indicando sucesso