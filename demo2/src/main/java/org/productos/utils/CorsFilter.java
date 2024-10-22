package org.productos.utils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        containerRequestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerRequestContext.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, jwt, username, password"); // Agrega username y password
        containerRequestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
        containerRequestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Content-Type", "application/json");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, jwt, username, password"); // Agrega username y password
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
        containerResponseContext.getHeaders().add("X-Content-Type-Options", "nosniff");

        // Agregar cabeceras de seguridad adicionales
        containerResponseContext.getHeaders().add("X-Frame-Options", "DENY");
        containerResponseContext.getHeaders().add("X-XSS-Protection", "1");
        containerResponseContext.getHeaders().add("Strict-Transport-Security", "max-age=31536000");
        containerResponseContext.getHeaders().add("Referrer-Policy", "strict-origin-when-cross-origin");
    }
}
