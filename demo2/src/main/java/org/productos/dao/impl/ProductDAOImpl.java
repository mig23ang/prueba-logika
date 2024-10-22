package org.productos.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.productos.dao.contract.IProductoDAO;
import org.productos.dao.entity.ProductsEntity;

import java.util.List;

@ApplicationScoped
public class ProductDAOImpl implements IProductoDAO {

    @Inject
    Logger logger;

    @Override
    public void deleteProducto(Long id) {
        logger.info("Inicia eliminación de producto en ProductsDaoImpl");
        try {
            ProductsEntity product = ProductsEntity.findById(id);
            if (product != null) {
                product.delete();
            }
        } catch (Exception e) {
            logger.error("Error al eliminar el producto con id " + id, e);
        }
    }

    @Override
    public ProductsEntity getProducto(Long id) {
        logger.info("Inicia búsqueda de producto en ProductsDaoImpl");
        try {
            return ProductsEntity.findById(id);
        } catch (Exception e) {
            logger.error("Error inesperado al buscar el producto con id " + id, e);
            return null;
        }
    }

    @Override
    public List<ProductsEntity> getAllProductos() {
        logger.info("Inicia búsqueda de productos en ProductsDaoImpl");
        try {
            return ProductsEntity.listAll();
        } catch (Exception e) {
            logger.error("Error inesperado al obtener la lista de productos", e);
            return List.of();
        }
    }

    @Override
    public ProductsEntity updateProducto(Long id, ProductsEntity producto) {
        logger.info("Inicia actualización de producto en ProductsDaoImpl");
        try {
            ProductsEntity existingProduct = ProductsEntity.findById(id);
            if (existingProduct != null) {
                existingProduct.setNombre(producto.getNombre()); // Usar setters
                existingProduct.setDescripcion(producto.getDescripcion());
                existingProduct.setStock(producto.getStock());
                existingProduct.setPrecio(producto.getPrecio());
                existingProduct.persistOrUpdate();  // Panache proporciona este método
            }
            return existingProduct;
        } catch (Exception e) {
            logger.error("Error inesperado al actualizar el producto con id " + id, e);
            return null;
        }
    }


    @Override
    public ProductsEntity createProducto(ProductsEntity producto) {
        logger.info("Inicia creación de producto en ProductsDaoImpl");
        try {
            producto.persist();  // Usa Panache para persistir
            return producto;
        } catch (Exception e) {
            logger.error("Error inesperado al crear el producto", e);
            return null;
        }
    }

    @Override
    public ProductsEntity findById(Long id) {
        logger.info("Inicia búsqueda de producto en ProductsDaoImpl");
        try {
            return ProductsEntity.findById(id);
        } catch (Exception e) {
            logger.error("Error inesperado al buscar el producto con id " + id, e);
            return null;
        }
    }
}
