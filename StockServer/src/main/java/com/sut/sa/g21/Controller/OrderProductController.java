/*
package com.sut.sa.g21.Controller;

import com.sut.sa.g21.Entity.OrderProduct;
import com.sut.sa.g21.Repository.OrderProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderProductController {
    private OrderProductRepository orderProductRepository;

    public OrderProductController(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @GetMapping("/OrderProduct")
    public Collection<OrderProduct> orderProducts(){
        return orderProductRepository.findAll();
    }
}
*/