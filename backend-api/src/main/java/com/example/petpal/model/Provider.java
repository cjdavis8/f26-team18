package com.example.petpal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "providers")
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String category;
    
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ServiceEntity> services;
}
