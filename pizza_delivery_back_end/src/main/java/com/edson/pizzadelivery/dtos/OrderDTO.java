package com.edson.pizzadelivery.dtos;

import com.edson.pizzadelivery.entities.Order;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderDTO
 *
 * @author : Edson Costa
 * @since : 05/01/2021
 **/
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private Order.OrderStatus status;

    private List<ProductDTO> productDTOS = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, Order.OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public OrderDTO(Order order) {
        id = order.getId();
        address = order.getAddress();
        latitude = order.getLatitude();
        longitude = order.getLongitude();
        moment = order.getMoment();
        status = order.getStatus();
        productDTOS = order.getProducts()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public void setStatus(Order.OrderStatus status) {
        this.status = status;
    }

    public List<ProductDTO> getProductDTOS() {
        return productDTOS;
    }
}
