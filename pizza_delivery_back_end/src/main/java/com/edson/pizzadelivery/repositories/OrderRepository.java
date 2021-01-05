package com.edson.pizzadelivery.repositories;

import com.edson.pizzadelivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {
}
