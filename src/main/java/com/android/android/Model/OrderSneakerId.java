package com.android.android.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderSneakerId implements Serializable {
    private Long order_id;
    private Long sneaker_id;

    public OrderSneakerId() {
    }

    public OrderSneakerId(Long orderId, Long sneakerId) {
        this.order_id = orderId;
        this.sneaker_id = sneakerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSneakerId that = (OrderSneakerId) o;
        return Objects.equals(order_id, that.order_id) &&
                Objects.equals(sneaker_id, that.sneaker_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, sneaker_id);
    }
}
