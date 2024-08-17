package com.supermarket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    /*
    name -> NOT NULL; Minimum 2 symbols
    price -> NOT NULL; Must be positive number
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "best_before")
    private Date bestBefore;

    @Lob
    private String description;

    @NotNull(message = "Product name cannot be NULL!")
    @Size(min = 2, message = "Product name must be minimum 2 symbols!")
    private String name;

    @NotNull(message = "Product price cannot be NULL!")
    @Positive(message = "Product price must be positive number!")
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_shops",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"))
    private List<Shop> shops;

    public Product(Date bestBefore, String description, String name, BigDecimal price, Category category) {
        this.bestBefore = bestBefore;
        this.description = description;
        this.name = name;
        this.price = price;
        this.category = category;
        this.shops = new ArrayList<>();
    }

    public void addShop(Shop shop) {
        this.shops.add(shop);
    }
}
