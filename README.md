# Atividade Produto-Testes

Este é um projeto Java que implementa um serviço para gerenciar produtos, com operações de CRUD (Criar, Ler, Atualizar, Excluir), utilizando um banco de dados MySQL e testes de integração com JUnit.

## Visão Geral

O serviço permite cadastrar, listar, atualizar e excluir produtos de um banco de dados MySQL. Além disso, foi criada uma camada de teste de integração para validar a funcionalidade de cada operação. Abaixo estão as instruções sobre como rodar o projeto e executar os testes.

## Pré-requisitos

- **Java 11 ou superior**
- **MySQL** (ou outro banco de dados compatível com JDBC)
- **JUnit 5** para os testes
- **Maven** para gerenciar dependências

## Instalação

1. Clone este repositório para o seu computador:
   
   ```
   git clone https://github.com/seuusuario/projeto-produto-service.git
   ````
   
## Configuração do Banco de Dados
O banco de dados utilizado neste projeto é o MySQL. Certifique-se de criar um banco de dados e configurar a conexão na classe ConexaoBanco conforme a necessidade do seu ambiente.
