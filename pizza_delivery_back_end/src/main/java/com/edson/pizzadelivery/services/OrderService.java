package com.edson.pizzadelivery.services;

import com.edson.pizzadelivery.dtos.OrderDTO;
import com.edson.pizzadelivery.dtos.ProductDTO;
import com.edson.pizzadelivery.entities.Order;
import com.edson.pizzadelivery.entities.Product;
import com.edson.pizzadelivery.repositories.OrderRepository;
import com.edson.pizzadelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static com.edson.pizzadelivery.entities.Order.*;

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

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = orderRepository.findOrdersWithProducts();

        return list
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null
                , dto.getAddress()
                , dto.getLatitude()
                , dto.getLongitude()
                , Instant.now()
                , OrderStatus.PENDING);

        for (ProductDTO productDTO : dto.getProducts()) {
            Product product = productRepository.getOne(productDTO.getId());
            order.getProducts().add(product);
        }

        order = orderRepository.save(order);

        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setDelivered(Long id) {
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);

        Order orderSaved = orderRepository.save(order);

        return new OrderDTO(orderSaved);
    }
}
