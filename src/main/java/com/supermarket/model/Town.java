package com.supermarket.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "towns")
@Getter
@Setter
@NoArgsConstructor
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "town_sequence")
    @GenericGenerator(
            name = "town_sequence",
            strategy = "com.supermarket.model.sequenceGenerators.TownSequenceGenerator")
    private String town_id;

    private String name;

    @OneToMany(mappedBy = "town", targetEntity = Shop.class)
    private List<Shop> shops;

    public Town(String name) {
        this.name = name;
        this.shops = new ArrayList<>();
    }

    public void addShop(Shop shop) {
        this.shops.add(shop);
    }
}
