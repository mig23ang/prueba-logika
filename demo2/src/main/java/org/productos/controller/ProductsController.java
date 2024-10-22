package org.productos.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.productos.gen.contract.V1ProductosApi;
import org.productos.gen.type.ProductoType;
import org.productos.services.impl.ProductsService;
import org.productos.utils.ApplicationException;

public class ProductsController implements V1ProductosApi {

    @Inject
    ProductsService productsService;
    @Inject
    Logger logger;


    @Override
    public Response createProduct(String username, String password, ProductoType productoType) {
        logger.info("Inicia creación de producto en ProductsController");
        System.out.println("username: ------------------" + username);
        try {
            logger.info("termina validación de usuario en ProductsController");
            return Response.ok(productsService.createProducto(productoType, username)).build();
        } catch (ApplicationException e) {
            logger.error("Error al crear producto: " + e.getMessage(), e);
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(e.getMessage())
                    .build();
        } catch (Exception e) {
            logger.error("Error inesperado al crear producto", e);
            return Response.serverError()
                    .entity("Error al crear el producto. Inténtalo de nuevo más tarde.")
                    .build();
        }
    }


    @Override
    public Response deleteProduct(Long id) {
        logger.info("inicia eliminacion de producto en ProductsController");
        try {
            productsService.deleteProducto(id);
            return Response.ok().build();
        } catch (ApplicationException e) {
            logger.error("Error al eliminar producto", e);
            throw new ApplicationException("Error al eliminar producto");
        } catch (Exception e) {
            logger.error("Error al eliminar producto", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getProductById(Long id) {
        logger.info("inicia busqueda de producto en ProductsController");
        try {
            return Response.ok(productsService.getProducto(id)).build();
        } catch (ApplicationException e) {
            logger.error("Error al buscar producto", e);
            throw new ApplicationException("Error al buscar producto");
        } catch (Exception e) {
            logger.error("Error al buscar producto", e);
            return Response.serverError().build();
        }
    }

    @Override
    public Response getProducts(String username, String password) {
        logger.info("Inicia búsqueda de productos en ProductsController");
        try {
            logger.info("termina validación de usuario en ProductsController");
            return Response.ok(productsService.getAllProductos(username)).build();
        } catch (ApplicationException e) {
            logger.error("Error al buscar productos: " + e.getMessage(), e);
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(e.getMessage())
                    .build();
        } catch (Exception e) {
            logger.error("Error inesperado al buscar productos", e);
            return Response.serverError()
                    .entity("Error al buscar los productos. Inténtalo de nuevo más tarde.")
                    .build();
        }
    }


    @Override
    public Response updateProduct(Long id, ProductoType productoType) {
        logger.info("inicia actualizacion de producto en ProductsController");
        try {
            return Response.ok(productsService.updateProducto(id, productoType)).build();
        } catch (ApplicationException e) {
            logger.error("Error al actualizar producto", e);
            throw new ApplicationException("Error al actualizar producto");
        } catch (Exception e) {
            logger.error("Error al actualizar producto", e);
            return Response.serverError().build();
        }
    }


}