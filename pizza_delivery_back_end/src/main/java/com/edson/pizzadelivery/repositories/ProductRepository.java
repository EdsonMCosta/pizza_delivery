package com.edson.pizzadelivery.repositories;

import com.edson.pizzadelivery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ProductRepository
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByNameAsc();
}
