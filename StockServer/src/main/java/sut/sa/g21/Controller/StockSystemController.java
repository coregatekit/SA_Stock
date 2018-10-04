package sut.sa.g21.Controller;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import sut.sa.g21.Entity.*;
import sut.sa.g21.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockSystemController {
    @Autowired private OrderProductRepository orderProductRepository;
    @Autowired private StockRepository stockRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private WarehouseRepository warehouseRepository;

    // OrderProduct
    @GetMapping("/OrderProduct")
    public Collection<OrderProduct> orderProducts(){
        return orderProductRepository.findAll();
    }
    @GetMapping("/Product/{orderproductId}")
    public Optional<OrderProduct> takeinOrderProductByid(@PathVariable Long orderproductId) {
        return orderProductRepository.findById(orderproductId);
    }

    // Stock
    @GetMapping("/Stock")
    public Collection<Stock> stocks() {
        return stockRepository.findAll();
    }
    @GetMapping("/Stock/{stockId}")
    public Optional<Stock> takeinStockByid(@PathVariable Long stockId) {
        return stockRepository.findById(stockId);
    }

    // Product
    @GetMapping("/Product")
    public Collection<Product> products() {
        return productRepository.findAll();
    }
    @GetMapping("/Product/{productId}")
    public Optional<Product> takeinProductByid(@PathVariable Long productId ) {
        return productRepository.findById(productId);
    }
    @PostMapping("/Product/addProduct/{productName}/{productDetail}/{productImgUrl}/{productPrice}")
    public Product addProduct(@PathVariable String productName, @PathVariable String productDetail, @PathVariable String productImgUrl, @PathVariable double productPrice) {
        Product newProduct = new Product();
        newProduct.setProductName(productName);
        newProduct.setProductDetail(productDetail);
        newProduct.setProductImgUrl(productImgUrl);
        newProduct.setProductPrice(productPrice);
        return productRepository.save(newProduct);
    }

    // Warehouse
    @GetMapping("/Warehouse")
    public Collection<Warehouse> warehouses() {
        return warehouseRepository.findAll();
    }
    @GetMapping("/Warehouse/{warehouseId}")
    public Optional<Warehouse> takeinWarehouseByid(@PathVariable Long warehouseId) {
        return warehouseRepository.findById(warehouseId);
    }

}