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

import com.proyect.parcial.models.Brand;
import com.proyect.parcial.services.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ArrayList<Brand> getBrands(){
        return brandService.getBrands();
    }

    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    @GetMapping(path = "/{id}")
    public Optional<Brand> getBrandById(@PathVariable("id") Long id){
        return brandService.getBrandById(id);
    }

    @PutMapping(path = "/{id}")
    public Brand updateById(@RequestBody Brand brand,@PathVariable("id") Long id){
        return brandService.updateById(brand,id);
    }

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
