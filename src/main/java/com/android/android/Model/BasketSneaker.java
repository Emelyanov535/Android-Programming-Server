package com.android.android.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "basket_sneaker")
@Getter
@Setter
@NoArgsConstructor
public class BasketSneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "sneaker_id")
    private Sneaker sneaker;

    private int quantity;

    public BasketSneaker(Basket basket, Sneaker sneaker, int quantity) {
        this.basket = basket;
        this.sneaker = sneaker;
        this.quantity = quantity;
    }
}
