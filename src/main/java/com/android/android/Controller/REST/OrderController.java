package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Controller.DTO.SneakerDTO;
import com.android.android.Model.Order;
import com.android.android.Model.Sneaker;
import com.android.android.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/order"})
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getSneaker/{id}")
    public List<SneakerDTO> getSneakerFromOrder(@PathVariable Long id){
        return orderService.getSneakerFromOrder(id).stream()
                .map(SneakerDTO::new)
                .toList();
    }

    @PostMapping("/create")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return new OrderDTO(orderService.createOrder(orderDTO));
    }
}
