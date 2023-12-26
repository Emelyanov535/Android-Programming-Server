package com.android.android.Service;

import com.android.android.Controller.DTO.ExpandedOrderDTO;
import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Controller.DTO.ReportDTO;
import com.android.android.Controller.DTO.SneakerCountPair;
import com.android.android.Model.*;
import com.android.android.Repository.OrderRepository;
import com.android.android.Repository.OrderSneakerRepository;
import com.android.android.Repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderSneakerRepository orderSneakerRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderSneakerRepository orderSneakerRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderSneakerRepository = orderSneakerRepository;
    }

    @Transactional(readOnly = true)
    public Order findOrderById(Long id){
        return orderRepository.getReferenceById(id);
    }

    @Transactional
    public Order createOrder(OrderDTO orderDTO){
        Order order = new Order(orderDTO.getDate(), orderDTO.getCity(), orderDTO.getStreet(), orderDTO.getHouse(), orderDTO.getSubtotal(), orderDTO.getTaxes(), orderDTO.getTotal(), userRepository.getReferenceById(orderDTO.getUserId()));
        return orderRepository.save(order);
    }

    @Transactional
    public OrderSneaker createSneakerOrder(OrderSneaker orderSneaker){
        return orderSneakerRepository.save(orderSneaker);
    }

    @Transactional
    public List<Order> getUserOrders(Long userId){
        User user = userRepository.getReferenceById(userId);
        return user.getOrders();
    }

    @Transactional
    public List<Sneaker> getSneakerFromOrder(Long orderId){
        Order order = orderRepository.getReferenceById(orderId);
        return order.getOrderSneakers()
                .stream()
                .map(orderSneaker -> new Sneaker(orderSneaker.getSneaker().getBrand(), orderSneaker.getSneaker().getDescription(), orderSneaker.getSneaker().getModel(), orderSneaker.getSneaker().getPrice(), orderSneaker.getSneaker().getPhoto()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteOrder(Long orderId){
        orderRepository.delete(findOrderById(orderId));
    }

    @Transactional
    public ReportDTO getReportOrders(Long dateFrom, Long dateTo){
        return new ReportDTO(
                orderRepository.countOrdersBetweenDate(dateFrom, dateTo),
                orderRepository.averageTotalBetweenDate(dateFrom, dateTo),
                orderRepository.getMostFrequentSneakersBetweenDate(dateFrom, dateTo).stream().map(SneakerCountPair::new).toList(),
                orderRepository.getOrderBetweenDate(dateFrom, dateTo).stream().map(ExpandedOrderDTO::new).toList()
        );
    }
}
