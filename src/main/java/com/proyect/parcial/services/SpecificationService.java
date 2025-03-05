package com.proyect.parcial.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.parcial.models.Specification;
import com.proyect.parcial.repositories.ISpecificationRepository;

@Service
public class SpecificationService {

    @Autowired
    ISpecificationRepository specificationRepository;

    public ArrayList<Specification> getSpecifications(){
        return (ArrayList<Specification>) specificationRepository.findAll();
    }

    public Specification saveSpecification(Specification specification){
        return specificationRepository.save(specification);
    }

    public Optional<Specification> getSpecificationById(Long id){
        return specificationRepository.findById(id);
    }

    public Specification updateById(Specification specification,long id){
        Specification specificationToUpdate = specificationRepository.findById(id).get();
        specificationToUpdate.setDetails(specification.getDetails());
        specificationToUpdate.setComputer(specification.getComputer());
        return specificationRepository.save(specificationToUpdate);
    }
    
    public boolean deleteSpecification(Long id){
        try {
            specificationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
