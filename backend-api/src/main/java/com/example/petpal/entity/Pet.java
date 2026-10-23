package com.example.petpal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pets")
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String breed;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length=100)
    private int age;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length=100)
    private int weight;

    public Pet() {

    }

    public Long getId(){
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

        public int getWeight(){
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}