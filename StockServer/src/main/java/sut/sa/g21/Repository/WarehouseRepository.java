package sut.sa.g21.Repository;

import sut.sa.g21.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.sa.g21.Entity.Warehouse;

@RepositoryRestResource
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}