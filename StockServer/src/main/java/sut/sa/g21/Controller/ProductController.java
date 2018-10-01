package sut.sa.g21.Controller;

import sut.sa.g21.Entity.Product;
import sut.sa.g21.Repository.ProductRepository;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
