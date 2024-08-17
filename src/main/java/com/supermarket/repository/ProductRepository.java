package com.supermarket.repository;

import com.supermarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("""
           SELECT p FROM Product p WHERE p.name = :productName
           """)
    Product findByProductName(String productName);
}
