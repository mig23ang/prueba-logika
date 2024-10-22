package org.productos.services.contract;

import org.productos.gen.type.ProductoType;

import java.util.List;

public interface IProductoService {

    void deleteProducto(Long id);

    ProductoType getProducto(Long id);

    List<ProductoType> getAllProductos(String username);

    ProductoType updateProducto(Long id, ProductoType producto);

    ProductoType createProducto(ProductoType producto, String username);

    ProductoType findById(Long id);
}
