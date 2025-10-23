package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária responsável por estabelecer e fornecer a conexão com o banco de dados SQLite.
 */
public class DatabaseConnector {

    private static final String DB_URL = "jdbc:sqlite:acervo.db";

    public DatabaseConnector() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do SQLite não encontrado. Verifique a dependência Maven.");
            throw new RuntimeException("Falha ao carregar driver SQLite.", e);
        }
    }

    /**
     * Retorna uma nova conexão com o banco de dados.
     * @return Objeto Connection ativo.
     * @throws SQLException Se ocorrer um erro de conexão.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
