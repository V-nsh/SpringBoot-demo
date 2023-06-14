package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import com.example.demo.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return product.get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product, Long id) {
        Product existingProduct = getProductById(id);
        BeanUtils.copyProperties(product, existingProduct, "id");
        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }
}
