API de Gerenciamento de Livros

Aplicação Spring Boot para gerenciamento de livros com operações CRUD.

Tecnologias

Java 17
Spring Boot
Spring Data JPA
H2 Database

Estrutura do projeto

models → entidades JPA
repositories → acesso ao banco de dados
services → regras de negócio
controllers → endpoints REST

Endpoints

POST /livros
GET /livros
GET /livros/{id}
PUT /livros/{id}
DELETE /livros/{id}

Como testar

Os endpoints podem ser testados utilizando:

Postman
ou
Swagger: http://localhost:8080/swagger-ui/index.html
