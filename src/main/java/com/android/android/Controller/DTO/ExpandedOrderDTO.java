package com.android.android.Controller.DTO;

import com.android.android.Model.Order;
import com.android.android.Model.OrderSneaker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExpandedOrderDTO {
    private Long id;
    private Long date;
    private String city;
    private String street;
    private String house;
    private Double subtotal;
    private Double taxes;
    private Double total;
    private String user;
    private List<SneakerDTO> sneakerList;

    public ExpandedOrderDTO(Order order) {
        this.id = order.getId();
        this.date = order.getDate();
        this.city = order.getCity();
        this.street = order.getStreet();
        this.house = order.getHouse();
        this.subtotal = order.getSubtotal();
        this.taxes = order.getTaxes();
        this.total = order.getTotal();
        this.user = order.getUser().getName() + " " + order.getUser().getSurname();
        this.sneakerList = new ArrayList<>();
        for (OrderSneaker orderSneaker : order.getOrderSneakers()) {
            this.sneakerList.add(new SneakerDTO(orderSneaker.getSneaker()));
        }
    }
}
