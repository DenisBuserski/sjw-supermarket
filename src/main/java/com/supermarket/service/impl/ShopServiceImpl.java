package com.supermarket.service.impl;

import com.supermarket.ExceptionHandlerUtil;
import com.supermarket.model.*;
import com.supermarket.repository.ProductRepository;
import com.supermarket.repository.ShopRepository;
import com.supermarket.repository.TownRepository;
import com.supermarket.service.ShopService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public ShopServiceImpl(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addShop(String shopAddress, String shopName, Town town) {
        if (this.shopRepository.findByAddress(shopAddress).isPresent()) {
            log.info("Shop with address " + shopAddress + " already exists!");
        } else {
            try {
                Shop shop = new Shop(shopAddress, shopName, town);
                this.shopRepository.save(shop);
                log.info("Successfully created shop with name " + shop.getName());
            } catch (ConstraintViolationException e) {
                ExceptionHandlerUtil.handleConstraintViolationException(e);
            }
        }
    }

    @Override
    public void getAllProductsByShopId(int id) {
        Optional<List<Product>> allProductsByShopId = this.shopRepository.getAllProductsByShopId(id);

        if (allProductsByShopId.isEmpty()) {
            log.info("No products in shop with id {}", 1);
        } else {
            allProductsByShopId
                    .stream()
                    .forEach(products -> {
                        for (Product product : products) {
                            log.info("Shop with id {} contains product with name {}", 1, product.getName());
                        }
                    });
        }
    }

    @Override
    public void getSellersByShopId(int id) {
        Optional<List<Seller>> sellersByShopId = this.shopRepository.getAllSellersByShopId(id);

        if (sellersByShopId.isEmpty()) {
            log.info("No sellers in shop with id: {}", 1);
        } else {
            sellersByShopId
                    .stream()
                    .forEach(sellers -> {
                        for (Seller seller : sellers) {
                            log.info("Seller with name {} {} is in shop with id {}", seller.getFirstName(), seller.getLastName(), 1);
                        }
                    });
        }
    }

    @Override
    public void addProductToShops(String productName, List<String> shops) {
        Product product = this.productRepository.findByProductName(productName);
        Optional<List<Shop>> allShopsByName = this.shopRepository.getAllShopsByName(shops);

        if (!allShopsByName.isEmpty()) {
            allShopsByName
                    .stream()
                    .forEach(shopsByName -> {
                        for (Shop shop : shopsByName) {
                            shop.addProduct(product);
                            this.shopRepository.save(shop);
                            product.addShop(shop);
                            this.productRepository.save(product);
                            log.info("Added product with name {} to shop name {}", product.getName(), shop.getName());
                        }
                    });
        }

    }
}
