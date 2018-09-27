package com.stock.StockDB;

import com.stock.StockDB.Entity.*;
import com.stock.StockDB.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    // OrderProduct
    @GetMapping("/OrderProduct")
    public Collection<OrderProduct> orderProduct(){
        return orderProductRepository.findAll();
    }

    // Product
    @GetMapping("/Product")
    public Collection<Product> product(){
        return productRepository.findAll();
    }

    // Stock
    @GetMapping("/Stock")
    public Collection<Stock> stock(){
        return stockRepository.findAll();
    }

    // Warehouse
    @GetMapping("/Warehouse")
    public Collection<Warehouse> warehouse(){
        return warehouseRepository.findAll();
    }
}