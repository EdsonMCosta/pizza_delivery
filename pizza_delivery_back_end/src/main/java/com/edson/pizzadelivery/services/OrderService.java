package com.edson.pizzadelivery.services;

import com.edson.pizzadelivery.dtos.OrderDTO;
import com.edson.pizzadelivery.entities.Order;
import com.edson.pizzadelivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderService
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = orderRepository.findOrdersWithProducts();

        return list
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }
}
