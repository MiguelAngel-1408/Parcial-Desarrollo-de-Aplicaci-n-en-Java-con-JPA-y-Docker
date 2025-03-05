package com.proyect.parcial.models;

import java.util.List;

// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "brands")
public class Brand {

    // Primary key attribute that is mapped to the id column of the brands table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each brand
    private long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100) // Name of the brand cannot be null and has a maximum length of 100 characters
    private String name;

    // One brand can have multiple computers
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Computer> computers;
    
    // Getters and Setters for accessing and modifying the attributes of the Brand class

    // Returns the brand's ID
    public long getId() {
        return id;
    }

    // Returns the brand's name
    public String getName() {
        return name;
    }

    // Returns the list of computers of the brand
    public List<Computer> getComputers() {
        return computers;
    }

    // Sets the brand's ID
    public void setId(long id) {
        this.id = id;
    }

    // Sets the brand's name
    public void setName(String name) {
        this.name = name;
    }

    // Sets the list of computers of the brand
    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
}

