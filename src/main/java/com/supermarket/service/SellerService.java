package com.supermarket.service;

import com.supermarket.model.Seller;
import com.supermarket.model.Shop;

import java.math.BigDecimal;
import java.util.Optional;

public interface SellerService {
    void addSeller(String firstName, String lastName, int age, BigDecimal salary, Shop shop, Seller manager);

    Optional<Seller> findById(int sellerId);

    void updateManagerId(int managerId, int sellerId);
}
