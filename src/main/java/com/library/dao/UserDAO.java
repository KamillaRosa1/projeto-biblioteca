package com.library.dao;

import com.library.model.User; // Importa a nova classe User
import java.util.List;

/*
 * Interface que define o contrato para as operações de acesso a dados (CRUD) da entidade User.
 */
public interface UserDAO {

    // Sub-item: Inserir (Create)
    /**
     * Insere um novo usuário no banco de dados.
     * @param user O objeto User a ser inserido.
     * @return O objeto User com o ID gerado pelo banco de dados.
     */
    User insert(User user);

    User findById(long id);

    List<User> findAll();

    // Sub-item: Editar (Update)
    /**
     * Atualiza os dados de um usuário existente.
     * @param user O objeto User com os dados a serem atualizados (o ID deve estar preenchido).
     * @return true se a atualização foi bem-sucedida, false caso contrário.
     */
    boolean update(User user);

    boolean delete(long id);

    // Método necessário para autenticação futura
    User findByContact(String contact);
}
