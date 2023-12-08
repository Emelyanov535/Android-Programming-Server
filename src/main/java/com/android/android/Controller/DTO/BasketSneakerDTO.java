package com.android.android.Controller.DTO;

import com.android.android.Model.BasketSneaker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketSneakerDTO {
    private Long basketId;
    private Long sneakerId;
    private Integer quantity;

    public BasketSneakerDTO(BasketSneaker basketSneaker){
        this.basketId = basketSneaker.getBasket().getId();
        this.sneakerId = basketSneaker.getSneaker().getId();
        this.quantity = basketSneaker.getQuantity();
    }
}
