# finances-alura
Projeto do desafio da Alura para back-end
## Como usar a API para testar - se trata de uma prova de conceito.

## URL Base: https://tsswebapps-finances-api.herokuapp.com

### Rotas

### Cadastro de Usuário - Necessário para usar os recursos fechados.
### /users
POST, enviar no corpo da requisição ```{
    "nome": "Thiago",
    "email": "thiago@yahoo.com.br",
    "senha": "123456"
}```

### Listagem de Categorias
## /categorias
GET. Categorias disponiveis para usar nos testes.

## CRUD - Receita
### /receitas

#### Caadastrar
POST, informar os dados no corpo da requisição. ```{
    "descricao":"Salario",
    "valor":7000,
    "dataLancamento":"2022-02-02"
}```

#### Listar Receitas
GET
### /receitas?descricao=s

#### Listar uma Receita
GET
### /receitas/1

#### Alterar - /receitas/1
PUT, informar os dados no corpo da requisição. ```{
    "descricao":"Salario",
    "valor":7000,
    "dataLancamento":"2022-02-02"
}```

#### Apagar
DEL
### receitas/1

#### Listar Receitas por ano/mês
GET
### /receitas/2022/2

# 

## CRUD - Despesas
### /despesas

#### Caadastrar
POST, informar os dados no corpo da requisição. ```{
    "descricao":"Salario",
    "valor":7000,
    "dataLancamento":"2022-02-02"
}```

#### Listar despesas
GET
### /despesas?descricao=s

#### Listar uma despesa
GET
### /despesas/1

#### Alterar - /despesas/1
PUT, informar os dados no corpo da requisição. ```{
    "descricao":"Salario",
    "valor":7000,
    "dataLancamento":"2022-02-02"
}```

#### Apagar
DEL
### despesas/1

#### Listar Receitas por ano/mês
GET
### /despesas/2022/2

# 
## Resumo
#
GET /resumo/2022/1




