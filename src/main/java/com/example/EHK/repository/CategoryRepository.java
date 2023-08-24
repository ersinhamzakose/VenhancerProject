package com.example.EHK.repository;

import com.example.EHK.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}