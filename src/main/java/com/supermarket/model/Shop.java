package com.supermarket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
public class Shop {
    /*
    address -> UNIQUE; NOT NULL; Minimum 2 symbols
    name -> Minimum 2 symbols
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Shop name cannot be NULL!")
    @Size(min = 2, message = "Shop address must be minimum 2 symbols!")
    @Column(unique = true)
    private String address;

    @Size(min = 2, message = "Shop name must be minimum 2 symbols!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "town_id")
    private Town town;

    @OneToMany(mappedBy = "shop", targetEntity = Seller.class)
    private List<Seller> sellers;

    @ManyToMany(mappedBy = "shops", targetEntity = Product.class, fetch = FetchType.EAGER)
    private List<Product> products;

    public Shop(String address, String name, Town town) {
        this.address = address;
        this.name = name;
        this.town = town;
        this.sellers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addSeller(Seller seller) {
        this.sellers.add(seller);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
