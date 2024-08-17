package com.supermarket.service.impl;

import com.supermarket.ExceptionHandlerUtil;
import com.supermarket.model.Seller;
import com.supermarket.model.Shop;
import com.supermarket.repository.SellerRepository;
import com.supermarket.service.SellerService;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void addSeller(String firstName, String lastName, int age, BigDecimal salary, Shop shop, Seller manager) {
        try {
            Seller seller = new Seller(firstName, lastName, age, salary, shop, manager);
            this.sellerRepository.save(seller);
            log.info("Successfully created seller with name {} {}",seller.getFirstName(), seller.getLastName());
        } catch (ConstraintViolationException e) {
            ExceptionHandlerUtil.handleConstraintViolationException(e);
        }
    }

    @Override
    public Optional<Seller> findById(int sellerId) {
        return this.sellerRepository.findById(sellerId);
    }

    @Override
    public void updateManagerId(int managerId, int sellerId) {
        this.sellerRepository.updateSellerNewManagerId(managerId, sellerId);
    }
}
