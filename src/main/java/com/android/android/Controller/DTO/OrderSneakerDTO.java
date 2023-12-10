package com.android.android.Controller.DTO;

import com.android.android.Model.BasketSneaker;
import com.android.android.Model.OrderSneaker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderSneakerDTO {
    private Long orderId;
    private Long sneakerId;
    private Integer quantity;

    public OrderSneakerDTO(OrderSneaker orderSneaker){
        this.orderId = orderSneaker.get_order().getId();
        this.sneakerId = orderSneaker.getSneaker().getId();
        this.quantity = orderSneaker.getQuantity();
    }
}
