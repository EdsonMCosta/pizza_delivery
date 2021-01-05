package com.edson.pizzadelivery.services;

import com.edson.pizzadelivery.dtos.ProductDTO;
import com.edson.pizzadelivery.entities.Product;
import com.edson.pizzadelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductService
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = productRepository.findAllByOrderByNameAsc();

        return list
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}
