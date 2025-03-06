package com.proyect.parcial.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.*;

// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "brands")
public class Brand {

    // Primary key attribute that is mapped to the id column of the brands table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100)
    private String name;

    // One brand can have many computers
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Computer> computers = new ArrayList<>();

    public Brand() {}
    
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

