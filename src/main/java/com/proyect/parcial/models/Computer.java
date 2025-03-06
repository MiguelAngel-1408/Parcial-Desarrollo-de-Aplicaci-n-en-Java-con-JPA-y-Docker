package com.proyect.parcial.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

// Importing necessary JPA annotations for entity mapping

import jakarta.persistence.*;
;


// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String model;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    @JsonBackReference("store-computer")
    private Store store;

    @OneToOne(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("computer-specification")
    private Specification specification;

    @ManyToMany(mappedBy = "computers")
    private List<Client> clients = new ArrayList<>();

    public Computer() {}
     
    // Getters and Setters for accessing and modifying the attributes of the Computer class
    
    // Returns the computer's ID
    public long getId() {
        return id;
    }

    // Returns the computer's model
    public String getModel() {
        return model;
    }


    // Returns the store to which the computer belongs
    public Store getStore() {
        return store;
    }

    // Returns the brand of the computer
    public Brand getBrand() {
        return brand;
    }

    // Returns the specification of the computer
    public Specification getSpecification() {
        return specification;
    }

    // Sets the computer's ID
    public void setId(long id) {
        this.id = id;
    }

    // Sets the computer's model
    public void setModel(String model) {
        this.model = model;
    }

    // Sets the store to which the computer belongs
    public void setStore(Store store) {
        this.store = store;
    }

    // Sets the brand of the computer
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // Sets the specification of the computer
    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
      
}
