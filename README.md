# API Back-end Lancha - *Por: Gabriel Coutinho*
**Esta API é voltada para um sistema de viagens marítimas, onde nela é possível cadastrar lanchas que farão viagens entre as ilhas e por fim gerará um relatório de compra de passagens.**

# Requisitos
* **Para cadastrar uma embarcação, precisamos do Nome da embarcação, sendo ele único, limite de passageiros, hora de saída, local de destino e preço por bilhete;**

* **Na hora da compra, é necessário o comprador inserir seu nome;**

* **Não se faz necessário o cadastro de clientes na plataforma;**

* **Este serviço deve ser RESTFul.**

# Métodos http
* API - Ship
  
*POST*
**http://localhost:8080/api/v1/ship -> Cadastra uma nova embarcação**

*GET*
**http://localhost:8080/api/v1/ship -> Lista todos as embarcações cadastradas**

*GET*
**http://localhost:8080/api/v1/ship/hour/{hour} -> Busca embarcações por hora cadastrada**

*GET*
**http://localhost:8080/api/v1/ship/go/{role} -> Busca embarcações por local de destino**

*PATCH*
**http://localhost:8080/api/v1/ship/update/{id} -> Altera a hora de saída da embarcação através da busca pelo id**

*DELETE*
**http://localhost:8080/api/v1/ship/delete/{id} -> Deleta cadastro da embarcação através do id**

* API - Trip

*POST*
**http://localhost:8080/api/v1/trip -> Cria uma nova viagem**

*GET*
**http://localhost:8080/api/v1/trip -> Lista todas as viagens realizadas**

*GET*
**http://localhost:8080/api/v1/trip/buyer/{buyer} -> Filtra todas as viagens realizadas através do nome do comprador**

*DELETE*
**http://localhost:8080/api/v1/trip/delete/{id} -> Deleta cadastro de viagens através do id**

# Plataformas utilizadas
* Linguagem de programação -> JAVA
* Framework -> SpringBoot
* IDE -> Intellij
* Banco de Dados -> PostgreSQL
* Ambiente para versionamento de código -> Git e GitHub
* Ambiente para Contêinerização -> Docker



