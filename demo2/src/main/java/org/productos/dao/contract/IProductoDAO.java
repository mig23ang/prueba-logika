package org.productos.dao.contract;

import org.productos.dao.entity.ProductsEntity;

import java.util.List;


public interface IProductoDAO  {

    void deleteProducto(Long id);

    ProductsEntity getProducto(Long id);

    List<ProductsEntity> getAllProductos();

    ProductsEntity updateProducto(Long id, ProductsEntity producto);

    ProductsEntity createProducto(ProductsEntity producto);

    ProductsEntity findById(Long id);

}
