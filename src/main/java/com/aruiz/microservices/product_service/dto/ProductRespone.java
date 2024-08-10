package com.aruiz.microservices.product_service.dto;

import java.math.BigDecimal;

public record ProductRespone(String id, String name, String description, BigDecimal price) {
}
