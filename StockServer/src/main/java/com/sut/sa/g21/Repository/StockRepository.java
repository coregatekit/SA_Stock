package com.sut.sa.g21.Repository;

import com.sut.sa.g21.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByOrderProduct(OrderProduct id);
}