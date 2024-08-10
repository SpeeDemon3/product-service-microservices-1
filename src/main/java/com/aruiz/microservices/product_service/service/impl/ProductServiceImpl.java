package com.aruiz.microservices.product_service.service.impl;

import com.aruiz.microservices.product_service.dto.ProductRequest;
import com.aruiz.microservices.product_service.dto.ProductRespone;
import com.aruiz.microservices.product_service.model.Product;
import com.aruiz.microservices.product_service.repository.ProductRepository;
import com.aruiz.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createProduct(ProductRequest productRequest) {
        log.info("ProductRequest values: name={}, description={}, price={}",
                productRequest.name(), productRequest.description(), productRequest.price());

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        log.info("Product values: {}", product);
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    @Override
    public List<ProductRespone> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductRespone mapToProductResponse(Product product) {
        return new ProductRespone(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }

    @Override
    public ProductRespone findProductById(String id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return modelMapper.map(product.get(), ProductRespone.class);
        }

        throw new RuntimeException("404 - Product not found");

    }

    @Override
    public boolean deleteProductById(String id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {

            productRepository.deleteById(id);

            log.info("Product with id {} successfully removed", id);
            return true;

        }

        return false;
    }



}
