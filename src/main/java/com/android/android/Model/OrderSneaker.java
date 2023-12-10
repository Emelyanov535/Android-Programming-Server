package com.android.android.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_sneaker")
@Getter
@Setter
@NoArgsConstructor
public class OrderSneaker {
    @EmbeddedId
    private OrderSneakerId id;

    @ManyToOne
    @JoinColumn(name = "_order_id")
    private Order _order;

    @ManyToOne
    @JoinColumn(name = "_sneaker_id")
    private Sneaker sneaker;

    private int quantity;

    public OrderSneaker(Order order, Sneaker sneaker, int quantity) {
        this.id = new OrderSneakerId(order.getId(), sneaker.getId());
        this._order = order;
        this.sneaker = sneaker;
        this.quantity = quantity;
    }
}
