package org.productos.dao.contract;

import org.productos.dao.entity.UserEntity;

public interface IUserDAO {

    UserEntity getUser(String id);
}
