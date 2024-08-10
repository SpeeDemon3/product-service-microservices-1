package com.aruiz.microservices.product_service.service;

import com.aruiz.microservices.product_service.dto.ProductRequest;
import com.aruiz.microservices.product_service.dto.ProductRespone;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductRespone> getAllProducts();
    ProductRespone findProductById(String id);
    boolean deleteProductById (String id);
}
