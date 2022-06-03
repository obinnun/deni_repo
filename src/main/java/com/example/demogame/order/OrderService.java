package com.example.demogame.order;

import com.example.demogame.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderForUser(Long userId){
        return orderRepository.getReferenceById(userId);
    }
}
