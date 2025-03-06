package com.proyect.parcial.services;

// Importing the necessary classes from the Spring Boot framework
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyect.parcial.models.Specification;
import com.proyect.parcial.repositories.ISpecificationRepository;

// Service class for the Specification entity
@Service
public class SpecificationService {

    // Injecting the ISpecificationRepository interface to interact with the database
    @Autowired
    ISpecificationRepository specificationRepository;

    // Method to get all specifications from the database
    public ArrayList<Specification> getSpecifications(){
        return (ArrayList<Specification>) specificationRepository.findAll();
    }

    // Method to save a new specification to the database
    public Specification saveSpecification(Specification specification){
        return specificationRepository.save(specification);
    }

    // Method to get a specification by its ID
    public Optional<Specification> getSpecificationById(Long id){
        return specificationRepository.findById(id);
    }

    // Method to update a specification by its ID
    public Specification updateById(Specification specification,long id){
        Specification specificationToUpdate = specificationRepository.findById(id).get();
        specificationToUpdate.setDetails(specification.getDetails());
        specificationToUpdate.setComputer(specification.getComputer());
        return specificationRepository.save(specificationToUpdate);
    }
    
    // Method to delete a specification by its ID
    public boolean deleteSpecification(Long id){
        try {
            specificationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
