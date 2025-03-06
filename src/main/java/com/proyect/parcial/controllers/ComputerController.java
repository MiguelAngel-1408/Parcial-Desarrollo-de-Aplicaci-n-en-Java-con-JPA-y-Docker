package com.proyect.parcial.controllers;

import java.util.ArrayList;
import java.util.Optional;

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

@RestController
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public ArrayList<Computer> getComputers(){
        return computerService.getComputers();
    }

    @PostMapping
    public Computer saveComputer(@RequestBody Computer computer){
        return this.computerService.saveComputer(computer);
    }


    @GetMapping(path = "/{id}")
    public Optional<Computer> getComputerById(@PathVariable("id") Long id){
        return computerService.getComputerById(id);
    }

    @PutMapping(path = "/{id}")
    public Computer updateById(@RequestBody Computer computer,@PathVariable("id") Long id){
        return computerService.updateById(computer,id);
    }

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
