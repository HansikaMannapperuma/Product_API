package com.example.CRUD_API.repository;

import com.example.CRUD_API.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
}
