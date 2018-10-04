/*
package sut.sa.g21.Controller;

import sut.sa.g21.Entity.Product;
import sut.sa.g21.Repository.ProductRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/Product")
    public Collection<Product> products() {
        return productRepository.findAll();
    }
}
*/