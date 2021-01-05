package com.edson.pizzadelivery.controllers;

import com.edson.pizzadelivery.dtos.ProductDTO;
import com.edson.pizzadelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductController
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> listAll = productService.findAll();

        return ResponseEntity.ok(listAll);
    }
}
