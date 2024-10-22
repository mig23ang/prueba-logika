package org.productos.utils;

import jakarta.enterprise.context.ApplicationScoped;
import org.productos.dao.entity.ProductsEntity;
import org.productos.gen.type.ProductoType;
import org.modelmapper.ModelMapper;


@ApplicationScoped
public class MapperProducto {

    public ProductoType productoEntityToProductType(ProductsEntity productEntity) {

        return new ModelMapper().map(productEntity, ProductoType.class);
    }

    public ProductsEntity producTypeToEntity(ProductoType product) {

        return new ModelMapper().map(product, ProductsEntity.class);
    }
}