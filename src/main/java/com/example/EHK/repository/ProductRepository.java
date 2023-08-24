package com.example.EHK.repository;

import com.example.EHK.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}