package com.proyect.parcial.controllers;

// Java
import java.util.ArrayList;
import java.util.Optional;

// Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyect.parcial.models.Computer;
import com.proyect.parcial.services.ComputerService;

// Controller for Computer
@RestController
@RequestMapping("/computer")
public class ComputerController {

    // Service for Computer
    @Autowired
    private ComputerService computerService;

    // Get all computers
    @GetMapping
    public ArrayList<Computer> getComputers(){
        return computerService.getComputers();
    }

    // Save a computer
    @PostMapping
    public Computer saveComputer(@RequestBody Computer computer){
        return computerService.saveComputer(computer);
    }

    // Get a computer by ID
    @GetMapping(path = "/{id}")
    public Optional<Computer> getComputerById(@PathVariable("id") Long id){
        return computerService.getComputerById(id);
    }

    // Update a computer by ID
    @PutMapping(path = "/{id}")
    public Computer updateById(@RequestBody Computer computer,@PathVariable("id") Long id){
        return computerService.updateById(computer,id);
    }

    // Delete a computer by ID
    @DeleteMapping(path = "/{id}")
    public String deleteComputer(@PathVariable("id") Long id){
        boolean ok = computerService.deleteComputer(id);
        if (ok){
            return "Computer delete with ID: " + id;
        }else{
            return "Could not delete computer with id" + id;
        }
    }
    
}
