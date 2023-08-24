package com.example.EHK.controller;

import com.example.EHK.dto.ProductDTO;
import com.example.EHK.model.Product;
import com.example.EHK.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setStatus(product.getStatus());
            productDTO.setPrice(product.getPrice());
            productDTO.setDescription(product.getDescription());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setStatus(product.getStatus());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody Product _product) {
        Product product = productService.addProduct(_product);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setStatus(product.getStatus());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }
}
