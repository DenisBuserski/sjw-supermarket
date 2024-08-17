package com.supermarket.service;

import com.supermarket.model.Category;
import com.supermarket.model.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public interface ProductService {
    void addProduct(Date bestBeforeDate, String description, String productName, BigDecimal productPrice, Category category);
}
