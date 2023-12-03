package com.android.android.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long date;
    private String city;
    private String street;
    private String house;
    private Double subtotal;
    private Double taxes;
    private Double total;

    @ManyToMany
    @JoinTable(
            name = "order_sneaker",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "sneaker_id")
    )
    private List<Sneaker> sneakers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Order(Long date, String city, String house, Double subtotal, Double taxes, Double total, List<Sneaker> sneakers, User user){
        this.date = date;
        this.city = city;
        this.house = house;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.total = total;
        this.sneakers = sneakers;
        this.user = user;
    }
}
