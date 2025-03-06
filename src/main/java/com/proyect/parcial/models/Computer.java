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

    // Primary key attribute that is mapped to the id column of the computers table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100)
    private String model;

    // Many computers can have one brand
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    // Many computers can belong to one store
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    // Ignoring the store attribute to avoid infinite recursion
    @JsonBackReference("store-computer")
    private Store store;

    // One computer can have one specification
    @OneToOne(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    // Ignoring the specification attribute to avoid infinite recursion
    @JsonManagedReference("computer-specification")
    private Specification specification;

    // Many computers can belong to many clients
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
