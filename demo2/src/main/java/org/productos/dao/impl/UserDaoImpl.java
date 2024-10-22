package org.productos.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.productos.dao.contract.IUserDAO;
import org.productos.dao.entity.UserEntity;
import org.jboss.logging.Logger;

@ApplicationScoped
public class UserDaoImpl implements IUserDAO {

    @Inject
    Logger logger;

    @Override
    public UserEntity getUser(String username) {
        try {
            logger.info("Inicia búsqueda de usuario en UserDaoImpl");
            // Busca el usuario por username utilizando la consulta de Panache
            return UserEntity.find("username", username).firstResult(); // Retorna el primer resultado
        } catch (Exception e) {
            logger.error("Error inesperado al buscar el usuario con username " + username, e);
            return null;
        }
    }
}
