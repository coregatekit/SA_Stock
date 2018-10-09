package sut.sa.g21.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Collection<OrderProduct> orderProducts(){
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
    /*
    @PostMapping("/AddProduct")
    public void addProduct(@RequestBody String dataProduct) throws JsonParseException, IOException {
        final String decoded = URLDecoder.decode(dataProduct, "UTF-8");
        dataProduct = decoded;
        Product newProduct = new Product();
        if (dataProduct.charAt(0) == '{') {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataProduct);

            JsonNode jsonNode = actualObj.get("productName");
            newProduct.setProductName(jsonNode.textValue());
            jsonNode = actualObj.get("productDetail");
            newProduct.setProductDetail(jsonNode.textValue());
            jsonNode = actualObj.get("productImgUrl");
            newProduct.setProductImgUrl(jsonNode.textValue());
            jsonNode = actualObj.get("productProce");
            newProduct.setProductPrice(jsonNode.doubleValue());
            productRepository.save(newProduct);
        }
    }
    */
    // ทดสอบโดย ใช้คำสั่ง curl -iX POST http://localhost:8080/Product/addProduct/AWM/AWM/AWM/5900
    @PostMapping("/Products/addProduct/{productName}/{productDetail}/{productImgUrl}/{productPrice}")
    public Product addProduct(@PathVariable String productName, @PathVariable String productDetail, @PathVariable String productImgUrl, @PathVariable double productPrice) {
       Product newProduct = new Product();
       newProduct.setName(productName);
       newProduct.setDetail(productDetail);
       newProduct.setImgUrl(productImgUrl);
       newProduct.setPrice(productPrice);
       return productRepository.save(newProduct);
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
    
}