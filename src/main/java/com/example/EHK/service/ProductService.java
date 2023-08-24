package com.example.EHK.service;
import com.example.EHK.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import com.example.EHK.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return Streamable.of(productRepository.findAll()).filter(e -> e.getStatus().equals("1")).toList();
    }
    public Product addProduct(Product _product) {
        _product.setStatus("1");
        return productRepository.save(_product);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).filter(e -> e.getStatus().equals("1")).orElse(null);
    }
    public Product deleteProduct(Product _product) {
        _product.setStatus("0");
        return productRepository.save(_product);
    }
    public Product updateProduct(Product _product) {
        return productRepository.save(_product);
    }
}