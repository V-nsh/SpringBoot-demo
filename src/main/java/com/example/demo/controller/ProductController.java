package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

import com.example.demo.entity.Product;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }

    @PutMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }
}
