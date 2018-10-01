package sut.sa.g21.Controller;

import sut.sa.g21.Entity.Warehouse;
import sut.sa.g21.Repository.WarehouseRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WarehouseController {
    private WarehouseRepository warehouseRepository;

    public WarehouseController(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping("/Warehouse")
    public Collection<Warehouse> warehouses() {
        return warehouseRepository.findAll();
    }
}
