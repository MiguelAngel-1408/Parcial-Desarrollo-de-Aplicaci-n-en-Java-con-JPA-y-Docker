package com.proyect.parcial.models;

// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "computers")
public class Computer {


    // Primary key attribute that is mapped to the id column of the computers table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each computer
    private long id;


    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100) // Model of the computer cannot be null and has a maximum length of 100 characters
    private String model;

    // Many computers can belong to one store
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)  // Joining the store_id column in the computers table with the id column in the stores table
    private Store store;

    // Many computers can belong to one brand
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false) // Joining the brand_id column in the computers table with the id column in the brands table
    private Brand brand;


    // One computer has one specification
    @OneToOne(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true) // One-to-one mapping between the computer and specification tables
    private Specification specification;

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
