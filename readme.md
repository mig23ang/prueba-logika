# Proyecto de Gestión de Productos

Este proyecto incluye un backend basado en Quarkus y un frontend en React para gestionar productos. A continuación, encontrarás las instrucciones para levantar ambos entornos y una descripción de los endpoints disponibles.

## Requisitos

### Backend:
- Java 17+
- Maven
- Docker (opcional, para ejecutar el backend en un contenedor)

### Frontend:
- Node.js 18+

---

## 1. Instrucciones para levantar el Backend

### Paso 1: Clonar el repositorio

```bash
git clone https://github.com/usuario/proyecto-productos.git
cd proyecto-productos/backend


mvn clean install
mvn quarkus:dev

docker build -f src/main/docker/Dockerfile.jvm -t productos-backend .
docker run -i --rm -p 8080:8080 productos-backend
```

## Endpoints disponibles
Método	Endpoint	Descripción	Headers necesarios
GET	/v1/productos	Obtener todos los productos	username, password
POST	/v1/productos	Crear un nuevo producto	username, password
GET	/v1/productos/{id}	Obtener un producto por su ID	username, password
PUT	/v1/productos/{id}	Actualizar un producto existente	username, password
DELETE	/v1/productos/{id}	Eliminar un producto por su ID	username, password

``` bash
curl --location 'http://localhost:8080/v1/productos' \
--header 'username: miguel' \
--header 'password: 123'


curl --location --request POST 'http://localhost:8080/v1/productos' \
--header 'Content-Type: application/json' \
--header 'username: miguel' \
--header 'password: 123' \
--data-raw '{
    "nombre": "Producto de prueba",
    "precio": 100.0,
    "descripcion": "Descripción del producto",
    "stock": 10
}'
```