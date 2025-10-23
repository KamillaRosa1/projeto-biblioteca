package com.library.dao;

import com.library.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class UserDAOImplTest {

    private static UserDAO userDAO;
    private static DatabaseConnector connector;

    /**
     * Configura o ambiente de teste e a conexão.
     */
    @BeforeAll
    static void setUp() {
        // Instancia o conector e o DAO
        connector = new DatabaseConnector();
        userDAO = new UserDAOImpl(connector);

        // Bloco de limpeza
        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement()) {
        } catch (SQLException e) {
            // Ignora se o banco não estiver totalmente inicializado
        }
    }

    @Test
    void testInsertUserShouldReturnUserWithGeneratedId() {
        // Isso impede a falha de UNIQUE constraint se o teste for executado múltiplas vezes.
        String uniqueContact = "dao.teste." + System.nanoTime() + "@email.com";

        // ARRANGE: Cria um novo objeto User para inserção
        User newUser = new User(
                "Teste Insercao DAO",
                uniqueContact, // Usa o e-mail único
                "senha123",
                "user"
        );

        // ACT: Tenta inserir o usuário
        User insertedUser = userDAO.insert(newUser);

        // ASSERT 1: Verifica se a inserção foi bem-sucedida
        Assertions.assertNotNull(insertedUser, "O objeto User retornado não deve ser nulo. (SQLException ocorreu no insert)");

        // ASSERT 2: Verifica se o ID gerado é válido
        Assertions.assertTrue(insertedUser.getId() > 0, "O ID do usuário não foi gerado corretamente após a inserção.");

        // ASSERT 3 & 4: Confirmação dos dados
        Assertions.assertEquals(uniqueContact, insertedUser.getContact());
        Assertions.assertEquals("user", insertedUser.getRole());
    }
}
