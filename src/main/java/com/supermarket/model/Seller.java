package com.supermarket.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class Seller {
    /*
    firstName -> NOT NULL; Minimum 2 symbols
    lastName -> NOT NULL; Minimum 2 symbols
    age -> NOT NULL: Minimum 18 years
    salary -> NOT NULL; Must be positive number
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "First name cannot be NULL!")
    @Column(name = "first_name")
    @Size(min = 2, message = "First name must be minimum 2 symbols!")
    private String firstName;

    @NotNull(message = "Last name cannot be NULL!")
    @Column(name = "last_name")
    @Size(min = 2, message = "Last name must be minimum 2 symbols!")
    private String lastName;

    @NotNull(message = "Age cannot be NULL!")
    @Min(value = 18, message = "Seller must be at least 18 years old!")
    private int age;

    @NotNull(message = "Salary cannot be NULL!")
    @Positive(message = "Salary must be positive number!")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seller manager;

    @OneToMany(mappedBy = "manager")
    private List<Seller> employees;

    public Seller(String firstName, String lastName, int age, BigDecimal salary, Shop shop, Seller manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.shop = shop;
        this.manager = manager;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Seller employee) {
        this.employees.add(employee);
    }
}
