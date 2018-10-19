/*
package com.sut.sa.g21.Controller;

import com.sut.sa.g21.Entity.Stock;
import com.sut.sa.g21.Repository.StockRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StockController {
    private StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/Stock")
    public Collection<Stock> stocks() {
        return stockRepository.findAll();
    }
}
*/