package com.proyect.parcial.models;


// Importing necessary JPA annotations for entity mapping
import jakarta.persistence.*;


// Defining the class as a JPA entity to map it to a database table
@Entity
@Table(name = "specifications")
public class Specification {

    public Specification(){
    }

    // Primary key attribute that is mapped to the id column of the specifications table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs for each specification
    private Long id;

    // Column annotation to specify the name of the column in the database table
    @Column(nullable = false, length = 200) // Details of the specification cannot be null and has a maximum length of 200 characters
    private String details;

    // One specification belongs to one computer
    @OneToOne
    @JoinColumn(name = "computer_id", nullable = true)
    private Computer computer;

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
