package com.supermarket.repository;

import com.supermarket.model.Seller;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

    @Modifying
    @Transactional
    @Query("""
           UPDATE Seller s 
           SET s.manager.id = :ManagerId
           WHERE s.id = :sellerId
           """)
    void updateSellerNewManagerId(int ManagerId, int sellerId);
}
