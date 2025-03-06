package com.proyect.parcial.models;

import java.util.List;

// Importing necessary JPA annotations for entity mapping

import jakarta.persistence.*;



// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "clients")
public class Client {

    public  Client(){
    }

    // Primary key attribute that is mapped to the id column of the clients table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each client
    private long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 100) // Name of the client cannot be null and has a maximum length of 100 characters
    private String name;

    // Many clients can have many computers
    @ManyToMany
    @JoinTable(name = "client_computer",
     joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "computer_id")) // Joining the client_computer table with the clients and computers tables
    private List<Computer> computers;

    // Getters and Setters for accessing and modifying the attributes of the client class

    // Returns the client's ID
    public long getId() {
        return id;
    }

    // Returns the client's name
    public String getName() {
        return name;
    }

    // Returns the list of computers of the client
    public List<Computer> getComputers() {
        return computers;
    }

    // Sets the client's ID
    public void setId(long id) {
        this.id = id;
    }

    // Sets the client's name
    public void setName(String name) {
        this.name = name;
    }

    // Sets the list of computers of the client
    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
    
}
