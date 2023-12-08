package com.android.android.Model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BasketSneakerId implements Serializable {
    private Long basket;
    private Long sneaker;

    public BasketSneakerId() {
    }

    public BasketSneakerId(Long basketId, Long sneakerId) {
        this.basket = basketId;
        this.sneaker = sneakerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketSneakerId that = (BasketSneakerId) o;
        return Objects.equals(basket, that.basket) &&
                Objects.equals(sneaker, that.sneaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket, sneaker);
    }
}
