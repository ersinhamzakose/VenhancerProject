package com.example.EHK.service;
import com.example.EHK.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import com.example.EHK.repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return Streamable.of(categoryRepository.findAll()).filter(e -> e.getStatus().equals("1")).toList();
    }
    public Category addCategory(Category _category) {
        _category.setStatus("1");
        return categoryRepository.save(_category);
    }
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).filter(e -> e.getStatus().equals("1")).orElse(null);
    }
    public Category deleteCategory(Category _category) {
        _category.setStatus("0");
        return categoryRepository.save(_category);
    }
    public Category updateCategory(Category _category) {
        return categoryRepository.save(_category);
    }
}