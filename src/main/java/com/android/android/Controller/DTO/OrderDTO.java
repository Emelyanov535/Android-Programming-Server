package com.android.android.Controller.DTO;


import com.android.android.Model.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Schema(description = "Информация о заказе")
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long date;
    private String city;
    private String street;
    private String house;
    private Double subtotal;
    private Double taxes;
    private Double total;

    public OrderDTO(Order order) {
        this.date = order.getDate();
        this.city = order.getCity();
        this.street = order.getStreet();
        this.house = order.getHouse();
        this.subtotal = order.getSubtotal();
        this.taxes = order.getTaxes();
        this.total = order.getTotal();
    }
}
