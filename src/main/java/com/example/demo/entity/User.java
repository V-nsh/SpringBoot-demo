package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;
    private String email;
    private String password;
    private String name;
}   
// Customer, Products -> Entities
// Repository -> Interface -> JpaRepository
// Service -> Interface -> ServiceImpl
// Controller -> RestController
// Application -> Main

// Repos: customer, product