package com.android.android.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "_sneaker")
@Getter
@Setter
@NoArgsConstructor
public class Sneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private Integer photo;

    public Sneaker(String brand, String model, String description, Double price, Integer photo) {
        this.brand = brand;
        this.description = description;
        this.model = model;
        this.photo = photo;
        this.price = price;
    }
}
