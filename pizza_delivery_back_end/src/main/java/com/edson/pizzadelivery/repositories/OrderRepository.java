package com.edson.pizzadelivery.repositories;

import com.edson.pizzadelivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * OrderRepository
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT obj FROM Order obj " +
            "JOIN FETCH obj.products " +
            "WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findOrdersWithProducts();
}
