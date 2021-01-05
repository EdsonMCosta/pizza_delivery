package com.edson.pizzadelivery.controllers;

import com.edson.pizzadelivery.dtos.OrderDTO;
import com.edson.pizzadelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/insert")
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        dto = orderService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }
}
