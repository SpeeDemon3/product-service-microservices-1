# 🚀 **Product Service**

## 📄 **Description / Descripción**

**Product Service** is a microservice developed with **Spring Boot** that handles product management. This service allows:
**Product Service** es un microservicio desarrollado con **Spring Boot** que maneja la gestión de productos. Este servicio permite:

- Create products / Crear productos
- Consult products / Consultar productos
- Update products / Actualizar productos
- Delete products / Eliminar productos

The service uses  **MongoDB** as a database and is prepared to be run in a **Docker**, environment, which makes its deployment and scalability easier.
El servicio utiliza **MongoDB** como base de datos y está preparado para ser ejecutado en un entorno **Docker**, lo que facilita su despliegue y escalabilidad.

## 🛠️ **Tecnologías**

This project uses the following technologies:
Este proyecto utiliza las siguientes tecnologías:

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data MongoDB**
- **Spring Web**
- **Testcontainers**
- **Docker**
- **MongoDB**
- **Lombok**
- **JUnit 5**
- **RestAssured**

## 🔧 **Requisitos Previos**

Para ejecutar y desarrollar este proyecto, necesitarás:

- **Java 17** or higher / o superior
- **Maven 3.x** or higher / o superior
- **Docker** y **Docker Compose**
- **MongoDB** (optional if you don't want to use Docker for MongoDB / opcional si no deseas usar Docker para MongoDB)

## 📂 **Project Structure / Estructura del Proyecto**

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── aruiz
│   │   │           └── microservices
│   │   │               └── product_service
│   │   │                   ├── controller
│   │   │                   ├── model
│   │   │                   ├── repository
│   │   │                   ├── service
│   │   │                   └── dto
│   │   └── resources
│   │       ├── application.yml
│   └── test
│       └── java
│           └── com
│               └── aruiz
│                   └── microservices
│                       └── product_service
│                           └── ProductServiceImplTest.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md

🌐 API Access / Acceso a la API
Once the service is running, you will be able to access the exposed endpoints. For example, to create a new product:
Una vez que el servicio esté en ejecución, podrás acceder a los endpoints expuestos. Por ejemplo, para crear un nuevo producto:

POST http://localhost:8080/api/product
Content-Type: application/json

{
    "name": "Sample Product",
    "description": "Sample Description",
    "price": 19.99
}

⚙️ Configuration / Configuración
`application.yml`

  spring:
    data:
      mongodb:
        uri: mongodb://localhost:27017/product-service
    main:
      allow-bean-definition-overriding: true
  
  server:
    port: 8080

