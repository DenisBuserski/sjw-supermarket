package com.supermarket.service.impl;

import com.supermarket.model.Category;
import com.supermarket.model.Town;
import com.supermarket.repository.TownRepository;
import com.supermarket.service.TownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void addTown(String townName) {
        if (this.townRepository.findByName(townName).isPresent()) {
            log.info("Town with name " + townName + " already exists!");
        } else {
            Town town = new Town(townName);
            this.townRepository.save(town);
            log.info("Successfully created town with name " + town.getName());
        }
    }

    @Override
    public Town getTownById(String townId) {
        return this.townRepository.findById(townId).get();
    }
}
