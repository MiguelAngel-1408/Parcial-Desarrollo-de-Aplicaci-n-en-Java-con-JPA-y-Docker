package com.proyect.parcial.services;

// Importing necessary classes from other packages
import java.util.ArrayList;
import java.util.Optional;

// Importing necessary annotations for Spring service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyect.parcial.models.Brand;
import com.proyect.parcial.repositories.IBrandRepostory;

// Service class for the Brand entity
@Service
public class BrandService {
    
    // Injecting the Brand repository to access the database
    @Autowired
    IBrandRepostory brandRepository;

    // Method to get all brands from the database
    public ArrayList<Brand> getBrands(){
        return (ArrayList<Brand>) brandRepository.findAll();
    }

    // Method to save a brand to the database
    public Brand saveBrand(Brand brand){
        return brandRepository.save(brand);
    }

    // Method to get a brand by its ID
    public Optional<Brand> getBrandById(Long id){
        return brandRepository.findById(id);
    }

    // Method to update a brand by its ID
    public Brand updateById(Brand brand,long id){
        Brand brandToUpdate = brandRepository.findById(id).get();
        brandToUpdate.setName(brand.getName());
        brandToUpdate.setComputers(brand.getComputers());
        return brandRepository.save(brandToUpdate);
    }

    // Method to delete a brand by its ID
    public boolean deleteBrand(Long id){
        try {
            brandRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
