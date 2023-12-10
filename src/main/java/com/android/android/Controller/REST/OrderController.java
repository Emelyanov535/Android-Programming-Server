package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Controller.DTO.OrderSneakerDTO;
import com.android.android.Controller.DTO.SneakerDTO;
import com.android.android.Model.Order;
import com.android.android.Model.OrderSneaker;
import com.android.android.Service.OrderService;
import com.android.android.Service.SneakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/order"})
public class OrderController {
    private final OrderService orderService;
    private final SneakerService sneakerService;

    public OrderController(OrderService orderService, SneakerService sneakerService) {
        this.orderService = orderService;
        this.sneakerService = sneakerService;
    }

    @PostMapping("/createOrderSneaker")
    public OrderSneakerDTO createOrderSneaker(@RequestBody OrderSneakerDTO orderSneakerDTO){
        return new OrderSneakerDTO(orderService.createSneakerOrder(new OrderSneaker(
                orderService.findOrderById(orderSneakerDTO.getOrderId()),
                sneakerService.findSneaker(orderSneakerDTO.getSneakerId()),
                orderSneakerDTO.getQuantity())));
    }

    @PostMapping("/create")
    public Long createOrder(@RequestBody OrderDTO orderDTO){
        Order order = orderService.createOrder(orderDTO);
        return order.getId();
    }

    @GetMapping("/getUserOrders/{userId}")
    public List<OrderDTO> getUserOrders(@PathVariable("userId") Long userId){
        return orderService.getUserOrders(userId).stream().map(OrderDTO::new).toList();
    }

    @GetMapping("/getSneakerFromOrder/{orderId}")
    public List<SneakerDTO> getSneakerFromOrder(@PathVariable("orderId") Long orderId){
        return orderService.getSneakerFromOrder(orderId).stream().map(SneakerDTO::new).toList();
    }

    @GetMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
    }
}
