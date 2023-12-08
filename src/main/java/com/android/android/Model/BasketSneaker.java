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
    @EmbeddedId
    private BasketSneakerId id;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "sneaker_id")
    private Sneaker sneaker;

    private int quantity;

    public BasketSneaker(Basket basket, Sneaker sneaker, int quantity) {
        this.id = new BasketSneakerId(basket.getId(), sneaker.getId());
        this.basket = basket;
        this.sneaker = sneaker;
        this.quantity = quantity;
    }
}
