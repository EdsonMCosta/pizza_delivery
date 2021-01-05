package com.edson.pizzadelivery.controllers;

import com.edson.pizzadelivery.dtos.OrderDTO;
import com.edson.pizzadelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * OrderController
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> listAll(){
        List<OrderDTO> listAll = orderService.findAll();

        return ResponseEntity.ok(listAll);
    }
}
