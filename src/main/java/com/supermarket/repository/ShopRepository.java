package com.supermarket.repository;

import com.supermarket.model.Product;
import com.supermarket.model.Seller;
import com.supermarket.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Optional<Shop> findByAddress(String shopAddress);

    @Query("""
           SELECT s.products FROM Shop s WHERE s.id = :id
           """)
    Optional<List<Product>> getAllProductsByShopId(int id);

    @Query("""
           SELECT s.sellers FROM Shop s WHERE s.id = :id
           """)
    Optional<List<Seller>> getAllSellersByShopId(int id);

    @Query("""
           SELECT s FROM Shop s WHERE s.name IN (:shops)
           """)
    Optional<List<Shop>> getAllShopsByName(List<String> shops);
}
