package sut.sa.g21.Controller;

import sut.sa.g21.Entity.Stock;
import sut.sa.g21.Repository.StockRepository;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
