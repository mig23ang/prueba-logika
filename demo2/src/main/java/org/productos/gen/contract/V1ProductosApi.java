package org.productos.gen.contract;

import org.productos.gen.type.ProductoType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;



@Path("/v1/productos")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-10-21T20:27:25.607108700-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1ProductosApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response createProduct(@HeaderParam("username")   String username,@HeaderParam("password")   String password,ProductoType productoType);

    @DELETE
    @Path("/{id}")
    Response deleteProduct(@PathParam("id") Long id);

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    Response getProductById(@PathParam("id") Long id);

    @GET
    @Produces({ "application/json" })
    Response getProducts(@HeaderParam("username")   String username,@HeaderParam("password")   String password);

    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response updateProduct(@PathParam("id") Long id,ProductoType productoType);
}
