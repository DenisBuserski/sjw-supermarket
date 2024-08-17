package com.supermarket.service.impl;

import com.supermarket.ExceptionHandlerUtil;
import com.supermarket.model.Category;
import com.supermarket.model.Product;
import com.supermarket.model.Shop;
import com.supermarket.repository.ProductRepository;
import com.supermarket.service.ProductService;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Date bestBeforeDate, String description, String productName, BigDecimal productPrice, Category category) {
        try {
            Product product = new Product(bestBeforeDate, description, productName, productPrice, category);
            this.productRepository.save(product);
            log.info("Successfully created product with name " + product.getName());
        } catch (ConstraintViolationException e) {
            ExceptionHandlerUtil.handleConstraintViolationException(e);
        }

    }


}
