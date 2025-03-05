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

import com.proyect.parcial.models.Specification;
import com.proyect.parcial.services.SpecificationService;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping
    public ArrayList<Specification> getSpecifications(){
        return specificationService.getSpecifications();
    }

    @PostMapping
    public Specification saveSpecification(@RequestBody Specification specification){
        return specificationService.saveSpecification(specification);
    }

    @GetMapping(path = "/{id}")
    public Optional<Specification> getSpecificationById(@PathVariable("id") Long id){
        return specificationService.getSpecificationById(id);
    }

    @PutMapping(path = "/{id}")
    public Specification updateById(@RequestBody Specification specification,@PathVariable("id") Long id){
        return specificationService.updateById(specification,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSpecification(@PathVariable("id") Long id){
        boolean ok = specificationService.deleteSpecification(id);
        if (ok){
            return "Specification delete with ID: " + id;
        }else{
            return "Could not delete specification with id" + id;
        }
    }
}
