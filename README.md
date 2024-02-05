# Tgid - Java Teste

API REST desenvolvida para o gerenciamento de transações entre clientes e empresas. A API permite a criação e listagem de clientes e empresas.
****

## Tecnologias

- Java 17
- h2 database
- Spring Boot
- Springdoc OpenAPI
- Lombok
- Spring Validation
- Spring Data JPA
****

## Como Ultilizar a API

- Clone este repositório do GitHub.
- Abra o projeto em sua IDE de escolha.
- Certifique-se de usar o Java 17.
- Execute a aplicação.
- Abra a documentação da API no navegador através de: `http://localhost:8080/swagger-ui.html`.
- Ultilize alguma ferramenta para verificar as requisições, ex: `INSOMINA`
- Caso queira acessar o console do h2 : `http://localhost:8080/h2-console`
****

## Entidades

- **Criar Cliente**: `POST http://localhost:8080/clientes`

#### Exemplo de script para criar um Cliente 

```json
{
  "nome": "Bruno",
  "cpf": "01234567890",
  "telefone": "11999999999",
  "email": "exemplo@exemplo.com.br"
}
```
****

- **Criar Empresa**: `POST http://localhost:8080/empresas`

#### Exemplo de script para criar uma Empresa

```json
{
    "nome": "Amazon 22",
    "cnpj": "59.229.647/0001-32"
}
```
****

- **Listar Clientes**: `GET http://localhost:8080/clientes`
#### Exemplo de saida

```json
[
    {
        "id": 3,
        "nome": "Lauandes",
        "cpf": "92421858097",
        "telefone": "11940589632",
        "email": "exemplo3@exemplo.com.br"
    },
    {
        "id": 1,
        "nome": "Jhonny",
        "cpf": "01234567890",
        "telefone": "11952496347",
        "email": "exemplo1@exemplo.com.br"
    },
    {
        "id": 2,
        "nome": "Bruno",
        "cpf": "98961376098",
        "telefone": "11996453215",
        "email": "exemplo2@exemplo.com.br"
    }
]
```

****

- **Listar Empresas**: `GET http://localhost:8080/empresas`
#### Exemplo de saida

```json
[
    {
        "id": 3,
        "nome": "Transform and grow in Digital",
        "cnpj": "38.130.819/0001-46"
    },
    {
        "id": 2,
        "nome": "UOL",
        "cnpj": "59.229.647/0001-32"
    },
    {
        "id": 1,
        "nome": "Amazon",
        "cnpj": "67.768.567/0001-83"
    }
]
```