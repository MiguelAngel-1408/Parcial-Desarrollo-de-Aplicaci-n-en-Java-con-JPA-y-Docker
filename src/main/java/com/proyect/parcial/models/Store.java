package com.proyect.parcial.models;

import java.util.List;


// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.*;



// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "stores")
public class Store {

    public  Store(){
    }
    // Primary key attribute that is mapped to the id column of the stores table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each store
    private long id;


    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100) // Name of the store cannot be null and has a maximum length of 100 characters
    private String name;

    // One store can have multiple computers
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<Computer> computers;

    // Getters and Setters for accessing and modifying the attributes of the Store class

    // Returns the stores's ID
    public long getId() {
        return id;
    }

    // Returns the store's name
    public String getName() {
        return name;
    }

    // Returns the list of computers in the store
    public List<Computer> getComputers() {
        return computers;
    }

    // Sets the store's ID
    public void setId(long id) {
        this.id = id;
    }

    // Sets the store's name
    public void setName(String name) {
        this.name = name;
    }

    // Sets the list of computers in the store
    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

}
