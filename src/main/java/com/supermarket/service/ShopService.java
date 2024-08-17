package com.supermarket.service;

import com.supermarket.model.Product;
import com.supermarket.model.Seller;
import com.supermarket.model.Town;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    void addShop(String shopAddress, String shopName, Town town);

    void getAllProductsByShopId(int id);

    void getSellersByShopId(int id);

    void addProductToShops(String productName, List<String> shops);
}
