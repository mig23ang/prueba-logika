package org.productos.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.productos.dao.entity.ProductsEntity;
import org.productos.dao.entity.UserEntity;
import org.productos.dao.impl.ProductDAOImpl;
import org.productos.dao.impl.UserDaoImpl;
import org.productos.gen.type.ProductoType;
import org.productos.services.contract.IProductoService;
import org.productos.utils.ApplicationException;
import org.productos.utils.MapperProducto;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductsService implements IProductoService {

    @Inject
    ProductDAOImpl productoDAO;

    @Inject
    MapperProducto mapperProducto;

    @Inject
    Logger logger;

    @Inject
    UserDaoImpl userDaoImpl;

    @Override
    public void deleteProducto(Long id) {
        logger.info("inicia eliminacion de producto en ProductsService");
        productoDAO.deleteProducto(id);
    }

    @Override
    public ProductoType getProducto(Long id) {
        logger.info("inicia busqueda de producto en ProductsService");
        ProductsEntity productEntity = productoDAO.getProducto(id);
        logger.info("termina busqueda de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(productEntity);
    }

    @Override
    public List<ProductoType> getAllProductos(String username) {
        logger.info("Inicia búsqueda de productos en ProductsService");
        validateAdminRole(username);
        List<ProductsEntity> productsEntityList = productoDAO.getAllProductos();
        logger.info("Termina búsqueda de productos en ProductsService");
        return productsEntityList.stream()
                .map(mapperProducto::productoEntityToProductType)
                .collect(Collectors.toList());
    }


    @Override
    public ProductoType updateProducto(Long id, ProductoType producto) {
        logger.info("inicia actualizacion de producto en ProductsService");
        ProductsEntity productEntity = mapperProducto.producTypeToEntity(producto);
        ProductsEntity updatedProduct = productoDAO.updateProducto(id, productEntity);
        logger.info("termina actualizacion de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(updatedProduct);
    }

    @Override
    public ProductoType createProducto(ProductoType producto, String username) {
        logger.info("inicia creacion de producto en ProductsService");
        validateAdminRole(username);
        ProductsEntity productEntity = mapperProducto.producTypeToEntity(producto);
        ProductsEntity createdProduct = productoDAO.createProducto(productEntity);
        logger.info("termina creacion de producto en ProductsService");
        return mapperProducto.productoEntityToProductType(createdProduct);

    }

    @Override
    public ProductoType findById(Long id) {
        logger.info("inicia busqueda de producto por id en ProductsService");
        ProductsEntity productEntity = productoDAO.findById(id);
        logger.info("termina busqueda de producto por id en ProductsService");
        return mapperProducto.productoEntityToProductType(productEntity);
    }

    /**
     * Método privado que valida si el usuario tiene rol de administrador.
     *
     * @param username El ID del usuario a validar.
     * @throws SecurityException Si el usuario no tiene permisos de administrador.
     */
    private void validateAdminRole(String username) {
        UserEntity user = userDaoImpl.getUser(username);

        // Verifica si el usuario no fue encontrado
        if (user == null) {
            logger.warn("Usuario no encontrado: " + username);
            throw new ApplicationException("El usuario no fue encontrado");
        }

        // Verifica si el rol del usuario es diferente a admin
        if (!"admin".equalsIgnoreCase(user.getRole())) {
            logger.warn("Usuario no autorizado para realizar esta operación: " + username);
            throw new ApplicationException("No tiene permisos para realizar esta operación");
        }
    }

}
