package com.supermarket.repository;

import com.supermarket.model.Town;
import com.supermarket.service.TownService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {
    Optional<Town> findByName(String townName);
}
