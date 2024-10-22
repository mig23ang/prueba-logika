package org.productos.dao.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@EqualsAndHashCode(callSuper = true)
@MongoEntity(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsEntity extends PanacheMongoEntity {

    private String nombre;

    private String descripcion;

    private Integer stock;

    private Integer precio;
}
