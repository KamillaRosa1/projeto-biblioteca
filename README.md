# Projeto: Sistema de Gerenciamento de Biblioteca

## 1. Visão Geral e Objetivos

Este projeto consiste na construção de um sistema de gerenciamento de acervo e usuários para uma biblioteca. O objetivo principal é prático: desenvolver a arquitetura e implementar as camadas de acesso a dados (DAO) e lógica de negócio.

O projeto é também uma ferramenta para o **aprendizado aprofundado** de:
* Padrões de projeto em Java.
* Conectividade de banco de dados (JDBC).
* Metodologias de teste de unidade (JUnit 5).

## 2. Tecnologias

* **Linguagem:** Java (JDK 17+)
* **Gerenciador de Dependências:** Apache Maven
* **Banco de Dados:** SQLite (Driver org.xerial:sqlite-jdbc)
* **Testes:** JUnit 5 (JUnit Jupiter)

## 3. Estrutura do Projeto

O projeto segue a estrutura padrão do Maven:

| Diretório | Conteúdo |
| :--- | :--- |
| `src/main/java` | Código-fonte da aplicação (DAOs, Models, etc.). |
| `src/test/java` | Código-fonte dos testes de unidade. |
| `sql/` | Arquivos de definição do esquema (`schema.sql`) e dados iniciais (`data.sql`). |

## 4. Configuração e Execução

### 4.1. Requisitos

* Java Development Kit (JDK) 17 ou superior.
* Apache Maven.

### 4.2. Inicialização do Banco de Dados

O banco de dados `acervo.db` deve ser criado e populado antes da execução dos testes.

1.  Crie o banco de dados (se não existir) e execute o esquema:
    ```bash
    sqlite3 acervo.db < sql/schema.sql
    ```
2.  (Opcional) Insira dados iniciais para testes:
    ```bash
    sqlite3 acervo.db < sql/data.sql
    ```

### 4.3. Execução dos Testes

Os testes validam a funcionalidade da camada DAO.

```bash
mvn test
```

## 5. Status da Implementação (UserDAO)

O progresso da implementação da camada de acesso a dados para a entidade `User` é registrado abaixo:

| Funcionalidade | Implementação (DAO) | Status |
| :--- | :--- | :--- |
| **Criar** | `insert(User user)` | ✅ Validado (Testes passando) |
| **Buscar por ID** | `findById(long id)` | ⬜ Pendente |
| **Buscar por Contato**| `findByContact(String contact)` | ⬜ Pendente |
