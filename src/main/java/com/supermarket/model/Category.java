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
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    /*
    name -> UNIQUE; NOT NULL; Minimum 2 symbols
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Category name cannot be NULL!")
    @Size(min = 2, message = "Category name must be minimum 2 symbols!")
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category", targetEntity = Product.class)
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
