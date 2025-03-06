package com.proyect.parcial.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.*;


// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "specifications")
public class Specification {


    // Primary key attribute that is mapped to the id column of the specifications table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each specification
    private Long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 200)
    private String details;

    // One computer can have one specification
    @OneToOne
    // Joining the computer_id column of the specifications table with the id column of the computers table
    @JoinColumn(name = "computer_id", nullable = false)
    // Ignoring the computer attribute to avoid infinite recursion
    @JsonBackReference("computer-specification")
    private Computer computer;

    // Default constructor
    public Specification() {}

    // Getters and Setters for accessing and modifying the attributes of the Specification class

    // Returns the specification's ID
    public Long getId() {
        return id;
    }

    // Returns the specification's details
    public String getDetails() {
        return details;
    }

    // Returns the computer to which the specification belongs
    public Computer getComputer() {
        return computer;
    }

    // Sets the specification's ID
    public void setId(Long id) {
        this.id = id;
    }

    // Sets the specification's details
    public void setDetails(String details) {
        this.details = details;
    }

    // Sets the computer to which the specification belongs
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
