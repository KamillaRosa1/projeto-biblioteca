-- Entrar no Shell do SQLite
-- Isso abre o banco de dados acervo.db (ou cria se não existir):
-- .\sqlite3.exe acervo.db

-- ----------------------------------------------------
-- Arquivo: data.sql
-- Objetivo: Inserir dados iniciais para testes
-- ----------------------------------------------------

-- ATIVAÇÃO DAS CHAVES ESTRANGEIRAS: ESSENCIAL para a tabela LOANS
PRAGMA foreign_keys = ON;

-- 1. ADM: Nome: Ana Silva, Contato: ana@email.com, Papel: adm
INSERT INTO users (name, contact, password, role, registration_date, is_active)
VALUES ('Ana Silva', 'ana@email.com', 'adm_senha_secreta', 'adm', DATE('now'), 1);

-- 2. USER: Nome: João Lima, Contato: joao@email.com, Papel: user
INSERT INTO users (name, contact, password, role, registration_date, is_active)
VALUES ('João Lima', 'joao@email.com', 'user_senha_simples', 'user', DATE('now'), 1);

-- Livro 1 (ID 1)
INSERT INTO books (title, author, publisher, pages, isbn, language, category, genre, published_date)
VALUES ('O Senhor dos Anéis', 'J.R.R. Tolkien', 'HarperCollins', 1200, '9788599296657', 'Português', 'Ficção', 'Fantasia', '1954-07-29');

-- Livro 2 (ID 2)
INSERT INTO books (title, author, publisher, pages, isbn, language, category, genre, published_date)
VALUES ('Código Limpo', 'Robert C. Martin', 'Alta Books', 450, '9788576082675', 'Português', 'Não-Ficção', 'Tecnologia', '2008-08-01');

-- Livro 3 (ID 3)
INSERT INTO books (title, author, publisher, pages, isbn, language, category, genre, published_date)
VALUES ('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 'HarperCollins', 100, '9788578270691', 'Português', 'Ficção', 'Fábula', '1943-04-06');

-- Empréstimo: Livro ID 1 emprestado para o Usuário ID 2
INSERT INTO loans (book_id, user_id, loan_date, return_date)
VALUES (1, 2, DATE('now'), NULL);