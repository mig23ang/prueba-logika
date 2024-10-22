package org.productos.dao.entity;


import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MongoEntity(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity extends PanacheMongoEntity {

    private String username;
    private String password;
    private String role;
}
