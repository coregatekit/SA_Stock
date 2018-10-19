package com.sut.sa.g21.Repository;

import com.sut.sa.g21.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.sa.g21.Entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}