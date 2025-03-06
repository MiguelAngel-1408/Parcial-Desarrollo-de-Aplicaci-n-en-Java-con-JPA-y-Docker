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
import com.proyect.parcial.models.Brand;
import com.proyect.parcial.services.BrandService;


// Controller for Brand
@RestController
// Path for the controller
@RequestMapping("/brand")
public class BrandController {

    // Service for Brand
    @Autowired
    private BrandService brandService;

    // Get all brands
    @GetMapping
    public ArrayList<Brand> getBrands(){
        return brandService.getBrands();
    }

    // Save a brand
    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    // Get a brand by ID
    @GetMapping(path = "/{id}")
    public Optional<Brand> getBrandById(@PathVariable("id") Long id){
        return brandService.getBrandById(id);
    }

    // Update a brand by ID
    @PutMapping(path = "/{id}")
    public Brand updateById(@RequestBody Brand brand,@PathVariable("id") Long id){
        return brandService.updateById(brand,id);
    }


    // Delete a brand by ID
    @DeleteMapping(path = "/{id}")
    public String deleteBrand(@PathVariable("id") Long id){
        boolean ok = brandService.deleteBrand(id);
        if (ok){
            return "Bran delete with ID: " + id;
        }else{
            return "Could not delete brand with id" + id;
        }
    }
    
}
