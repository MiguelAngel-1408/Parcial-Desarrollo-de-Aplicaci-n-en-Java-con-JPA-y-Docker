package com.proyect.parcial.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.parcial.models.Computer;
import com.proyect.parcial.repositories.IComputerRepository;

@Service
public class ComputerService {

    @Autowired
    IComputerRepository computerRepository;

    public ArrayList<Computer> getComputers(){
        return (ArrayList<Computer>) computerRepository.findAll();
    }

    public Computer saveComputer(Computer computer){
        return computerRepository.save(computer);
    }

    public Optional<Computer> getComputerById(Long id){
        return computerRepository.findById(id);
    }

    public Computer updateById(Computer computer,long id){
        Computer computerToUpdate = computerRepository.findById(id).get();
        computerToUpdate.setBrand(computer.getBrand());
        computerToUpdate.setModel(computer.getModel());
        computerToUpdate.setSpecification(computer.getSpecification());
        computerToUpdate.setStore(computer.getStore());
        return computerRepository.save(computerToUpdate);
    }

    public boolean deleteComputer(Long id){
        try {
            computerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
