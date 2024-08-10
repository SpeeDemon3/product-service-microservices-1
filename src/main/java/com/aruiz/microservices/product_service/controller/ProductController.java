package com.aruiz.microservices.product_service.controller;

import com.aruiz.microservices.product_service.dto.ProductRequest;
import com.aruiz.microservices.product_service.dto.ProductRespone;
import com.aruiz.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRespone> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductRespone findProductById(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deleteProductById(@PathVariable String id) {
        return productService.deleteProductById(id);
    }

}
