package sut.sa.g21.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.criteria.Order;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @GetMapping("/OrderProducts")
    public Collection<OrderProduct> orderProducts() {
        return orderProductRepository.findAll();
    }
        
    // Stock
    @GetMapping("/Stocks")
    public Collection<Stock> stocks() {
        return stockRepository.findAll();
    }
    

    // Product
    @GetMapping("/Products")
    public Collection<Product> products() {
        return productRepository.findAll();
    }
    @GetMapping("/Products/{productId}")
    public Optional<Product> takeinProductByid(@PathVariable Long productId ) {
        return productRepository.findById(productId);
    }
    @PostMapping("/Products/addProduct/{productName}/{productDetail}/{productImgUrl}/{productPrice}")
    public Product addProduct(@PathVariable String productName, @PathVariable String productDetail, @RequestBody String productImgUrl, @PathVariable double productPrice) {
       Product newProduct = new Product();
       newProduct.setProductName(productName);
       newProduct.setProductDetail(productDetail);
       newProduct.setProductImgUrl(productImgUrl);
       newProduct.setProductPrice(productPrice);
       return productRepository.save(newProduct);
    }
    @RequestMapping(value = "/Products/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Product addProduct2(@RequestBody Product newProduct) {
       return productRepository.save(newProduct);
    }    
    @PutMapping("/Products/editProduct/{productId}/{newProductName}/{productDetail}/{productImgUrl}/{productPrice}")
    public Product editProduct(@PathVariable Long productId, @PathVariable String newProductName, @PathVariable String productDetail, @RequestBody String productImgUrl, @PathVariable double productPrice) {
        Product editProduct =  productRepository.findById(productId).get();
        editProduct.setProductName(newProductName);
        editProduct.setProductDetail(productDetail);
        editProduct.setProductImgUrl(productImgUrl);
        editProduct.setProductPrice(productPrice);
        return productRepository.save(editProduct);
    }
    @RequestMapping(value = "/Products/editProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Product editProduct2(@RequestBody Product editProduct) {
       return productRepository.save(editProduct);
    }

    // Warehouse
    @GetMapping("/Warehouses")
    public Collection<Warehouse> warehouses() {
        return warehouseRepository.findAll();
    }
    @GetMapping("/Warehouses/{warehouseId}")
    public Optional<Warehouse> takeinWarehouseByid(@PathVariable Long warehouseId) {
        return warehouseRepository.findById(warehouseId);
    }
    

    @PostMapping("/addOrderProduct")
    public OrderProduct addOrderProducts(@PathVariable double TotalPrice, @PathVariable Long PreOderNo, @PathVariable int ProductAmount) {
        OrderProduct newOrderProduct = new OrderProduct();
        newOrderProduct.setTotalPrice(TotalPrice);
        newOrderProduct.setPreOrderId(PreOderNo);
        newOrderProduct.setAmount(ProductAmount);
        return orderProductRepository.save(newOrderProduct);
    }
    @PostMapping("/addStock")
    public Stock addStocks(@PathVariable Product productId, @PathVariable Warehouse warehouseId) {
        Stock newStock = new Stock();
        newStock.setProductId(productId);
        newStock.setWarehouseId(warehouseId);
        return stockRepository.save(newStock);
    }

    
    
    @PostMapping("/addOrderProduct/{productId}/{productAmount}/{totalPrice}/{preorderId}/{warehouseId}")
    public Stock newOrderProduct(OrderProduct newOrder, @PathVariable Long productId, @PathVariable int productAmount, @PathVariable double totalPrice, @PathVariable Long preorderId, @PathVariable Long warehouseId) {
        Optional<Product> takeProduct = productRepository.findById(productId);
        Optional<Warehouse> takeWarehouse = warehouseRepository.findById(warehouseId);
        newOrder.setAmount(productAmount);
        newOrder.setTotalPrice(totalPrice);
        newOrder.setPreOrderId(preorderId);
        orderProductRepository.save(newOrder);

        Optional<OrderProduct> takeOrderProduct = orderProductRepository.findById(newOrder.getId());
        Stock newStock = new Stock();
        newStock.setProductId(takeProduct.get());
        newStock.setWarehouseId(takeWarehouse.get());
        newStock.setOrderProductId(takeOrderProduct.get());
        return stockRepository.save(newStock);
    }
    
    
    /*
    @PostMapping("/addOrderProduct/{productId}/{productAmount}/{totalPrice}/{preorderId}/{warehouseId}")
    public void newOrder(OrderProduct newOrder, @PathVariable Product productId, @PathVariable int productAmount, @PathVariable double totalPrice, @PathVariable Long preorderId, @PathVariable Warehouse warehouseId) {
        
        addOrderProducts(totalPrice, preorderId, productAmount);
        addStocks(productId, warehouseId);
        
    }
    */
    
    
}