package com.android.android.Controller.DTO;

import com.android.android.Model.Order;
import com.android.android.Model.Sneaker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SneakerCountPair {
    private SneakerDTO  sneaker;
    private Long quantity;

    public SneakerCountPair(SneakerDTO sneaker, Long quantity){
        this.sneaker = sneaker;
        this.quantity = quantity;
    }

    public SneakerCountPair(Object[] objects) {
        this.sneaker = new SneakerDTO((Sneaker) objects[0]);
        this.quantity = (Long) objects[1];
    }
}
