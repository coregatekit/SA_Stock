package com.stock.StockDB.Repository;

import com.stock.StockDB.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    
}