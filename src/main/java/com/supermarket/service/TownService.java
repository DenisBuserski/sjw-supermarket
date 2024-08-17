package com.supermarket.service;

import com.supermarket.model.Town;

import java.util.List;

public interface TownService {
    void addTown(String townName);

    Town getTownById(String townId);
}
