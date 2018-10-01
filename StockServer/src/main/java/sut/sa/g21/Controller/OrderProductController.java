package sut.sa.g21.Controller;

import sut.sa.g21.Entity.OrderProduct;
import sut.sa.g21.Repository.OrderProductRepository;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
