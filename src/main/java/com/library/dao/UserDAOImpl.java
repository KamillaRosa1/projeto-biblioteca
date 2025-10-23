package com.library.dao;

import com.library.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Implementação da interface UserDAO utilizando JDBC para interação com o SQLite.
 */
public class UserDAOImpl implements UserDAO {

    // 6 placeholders '?' para name, contact, password, role, registration_date e is_active
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (name, contact, password, role, registration_date, is_active) VALUES (?, ?, ?, ?, ?, ?)";

    private static final DateTimeFormatter SQL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DatabaseConnector connector;

    public UserDAOImpl(DatabaseConnector connector) {
        this.connector = connector;
    }

    @Override
    public User insert(User user) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            // 1. Mapeamento dos 6 parâmetros
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getContact());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getRegistrationDate().format(SQL_DATE_FORMATTER));
            preparedStatement.setInt(6, user.isActive() ? 1 : 0);

            // 2. Execução da inserção
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                return null;
            }

            // 3. RECUPERAÇÃO DO ID: Método específico e robusto para SQLite
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("SELECT last_insert_rowid()")) {

                if (rs.next()) {
                    long generatedId = rs.getLong(1);
                    user.setId(generatedId);
                    return user; // SUCESSO
                } else {
                    return user;
                }
            }
        } catch (SQLException e) {
            // Este bloco é a causa da falha. A exceção exata está aqui.
            System.err.println("SQLException: Erro Crítico: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Métodos restantes
    @Override public User findById(long id) { return null; }
    @Override public List<User> findAll() { return null; }
    @Override public boolean update(User user) { return false; }
    @Override public boolean delete(long id) { return false; }
    @Override public User findByContact(String contact) { return null; }
}
