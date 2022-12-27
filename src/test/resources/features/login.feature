# language: pt

Funcionalidade: Logar no sistema
  Eu como usuario do sistema RG
  quero logar no sistema
  Para acessar um municipio e unidade

  Contexto: Visualizar tela de Login
    Dado que esteja na tela de login

  @loginValido
  Cenario: Visualizar municipios
    Quando eu preencho meu e-mail
    E preencho minha senha
    E clico em proximo
    Entao o login e efetuado com sucesso

  @loginInvalido
  Esquema do Cenario: Visualizar <name>
    Quando preencho email <email>
    E preencho senha <password>
    E clico no botao proximo
    Entao aparece <message> erro login

    Exemplos:
      | email         | password    | message  | name           |
      | qualquerc.com | 123456      |          | E-mail inválido|
      |               | 123456      |          | Senha inválida |
      | luan@teste.com|             |          | Senha vazia    |