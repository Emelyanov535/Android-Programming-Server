package com.android.android.Service;

import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Model.Order;
import com.android.android.Model.Sneaker;
import com.android.android.Repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public Order findOrderById(Long id){
        return orderRepository.getReferenceById(id);
    }

    @Transactional
    public List<Sneaker> getSneakerFromOrder(Long id){
        final Order order = findOrderById(id);
        return order.getSneakers();
    }

    //Доделать метод
    @Transactional
    public Order createOrder(OrderDTO orderDTO){
        Order order = new Order(orderDTO.getDate(), orderDTO.getCity(), orderDTO.getHouse(), orderDTO.getSubtotal(), orderDTO.getTaxes(), orderDTO.getTotal(), null, null);
        return orderRepository.save(order);
    }
}
