# PedidosBackend

Frontend: [Pedidos Frontend](https://github.com/sarahCamargo/pedidos-frontend)

## Funcionalidades

- **Módulo Produtos e Serviços**
  - Adicionar novos produtos ou serviços ao sistema.
  - Listar todos os produtos e serviços cadastrados.
  - Atualizar informações de produtos ou serviços existentes.
  - Remover produtos ou serviços do sistema.

- **Módulo Pedidos**
  - Criar novos pedidos, associando produtos e serviços.
  - Visualizar detalhes de pedidos existentes.
  - Atualizar o status dos pedidos.
  - Calcular o valor total dos pedidos com base nos itens selecionados.

## Tecnologias Utilizadas

- **Backend:** Spring Boot, JPA, Hibernate, PostgreSQL.
- **Frontend:** Angular


# Instruções para Configuração do Servidor Backend

## Pré-requisitos

1. **Java Development Kit (JDK)**: Necessário baixar a versão mais recente do JDK em [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou [OpenJDK](https://openjdk.java.net/install/).

2. **Apache Maven**: Necessário baixar o Maven em [maven.apache.org](https://maven.apache.org/download.cgi).

3. **PostgreSQL**: Necessário baixar o PostgreSQL em [postgresql.org](https://www.postgresql.org/download/).


## Passo a Passo

### 1. Criar um Banco de Dados

Após instalar o PostgreSQL, é necessário criar um banco de dados para a aplicação. 

Exemplo:

```sql
CREATE DATABASE pedidos;
```

### 2. Clonar o Repositório

```bash
git clone https://github.com/sarahCamargo/pedidos-backend
```

### 3. Configurar as Credenciais do Banco de Dados

No arquivo `src/main/resources/application.properties` devem ser configuradas as propriedades de conexão com o banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/banco_de_dados
spring.datasource.username=usuario
spring.datasource.password=senha
```

Necessário substituir `banco_de_dados`, `usuario` e `senha` pelos valores adequados.

### 4. Construir o Projeto

No diretório do projeto, é necessário executar o seguinte comando para construir a aplicação:

```bash
mvn clean install
```

### 5. Iniciar o Servidor

Para iniciar o servidor Spring Boot, é necessário executar o seguinte comando:

```bash
mvn spring-boot:run
```

### 6. Acessar a API

Após iniciar o servidor, é possível acessar a API em:

```
http://localhost:8080
```
