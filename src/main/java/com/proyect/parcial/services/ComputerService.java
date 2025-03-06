package com.proyect.parcial.services;

// Importing the necessary classes from the Spring Boot framework
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyect.parcial.models.Computer;
import com.proyect.parcial.repositories.IComputerRepository;

@Service
public class ComputerService {

    // Injecting the IComputerRepository interface to interact with the database
    @Autowired
    IComputerRepository computerRepository;

    // Method to get all computers from the database
    public ArrayList<Computer> getComputers(){
        return (ArrayList<Computer>) computerRepository.findAll();
    }

    // Method to save a new computer to the database
    public Computer saveComputer(Computer computer){
        return computerRepository.save(computer);
    }

    // Method to get a computer by its ID
    public Optional<Computer> getComputerById(Long id){
        return computerRepository.findById(id);
    }

    // Method to update a computer by its ID
    public Computer updateById(Computer computer,long id){
        Computer computerToUpdate = computerRepository.findById(id).get();
        computerToUpdate.setBrand(computer.getBrand());
        computerToUpdate.setModel(computer.getModel());
        computerToUpdate.setSpecification(computer.getSpecification());
        computerToUpdate.setStore(computer.getStore());
        return computerRepository.save(computerToUpdate);
    }

    // Method to delete a computer by its ID
    public boolean deleteComputer(Long id){
        try {
            computerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
