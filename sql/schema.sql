-- ----------------------------------------------------
-- Arquivo: schema.sql
-- Objetivo: Define a estrutura do banco de dados (acervo.db)
-- Utilização: Biblioteca para rastreio de usuários e empréstimos
-- ----------------------------------------------------

-- Tabela 1: USERS
-- Armazena os usuários do sistema com permissão e status de atividade.
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    contact TEXT NOT NULL UNIQUE, 
    password TEXT NOT NULL,
    role TEXT NOT NULL DEFAULT 'user', -- Papéis: 'user' ou 'adm'
    registration_date TEXT NOT NULL,  -- Data de cadastro (campo que faltava)
    is_active BOOLEAN NOT NULL DEFAULT 1 -- Status de atividade (campo que faltava)
);

-- Tabela 2: BOOKS
-- Catálogo de todas as publicações disponíveis.
CREATE TABLE IF NOT EXISTS books (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    author TEXT,
    publisher TEXT,
    pages INTEGER,
    isbn TEXT,
    language TEXT,
    category TEXT,
    genre TEXT,
    published_date TEXT
);

-- Tabela 3: LOANS
-- Rastreia os empréstimos.
CREATE TABLE IF NOT EXISTS loans (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    loan_date TEXT NOT NULL, 
    return_date TEXT,
    
    FOREIGN KEY(book_id) REFERENCES books(id),
    FOREIGN KEY(user_id) REFERENCES users(id)
);