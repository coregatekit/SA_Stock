package sut.sa.g21.Controller;

import sut.sa.g21.Entity.Warehouse;
import sut.sa.g21.Repository.WarehouseRepository;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
