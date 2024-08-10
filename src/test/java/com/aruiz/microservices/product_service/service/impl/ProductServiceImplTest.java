package com.aruiz.microservices.product_service.service.impl;

import com.aruiz.microservices.product_service.dto.ProductRequest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceImplTest {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.7");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.defaultParser = Parser.JSON;
    }

    static  {
        mongoDBContainer.start();
    }

    @Test
    void createProduct() {

        ProductRequest productRequest = getProductRequest();

        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.equalTo(getProductRequest().price().intValueExact()));
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest("Playstation 5", "Good state", BigDecimal.valueOf(375.23));
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void findProductById() {
    }

    @Test
    void deleteProductById() {
    }
}