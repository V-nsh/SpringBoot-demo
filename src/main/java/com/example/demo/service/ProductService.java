package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.entity.Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> updateProduct(Product product, String id) {
        Optional<Product> existingProduct = this.getProductById(id);
        if(existingProduct.isPresent()) {
            existingProduct.get().setName(product.getName());
            existingProduct.get().setPrice(product.getPrice());
            existingProduct.get().setDescription(product.getDescription());
            existingProduct.get().setImage(product.getImage());

            productRepository.save(existingProduct.get());
            return existingProduct;
        }
        return existingProduct;
    }
}
