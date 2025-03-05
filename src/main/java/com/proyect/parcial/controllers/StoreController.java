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

import com.proyect.parcial.models.Store;
import com.proyect.parcial.services.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ArrayList<Store> getStores(){
        return storeService.getStores();
    }

    @PostMapping
    public Store saveStore(@RequestBody Store store){
        return storeService.saveStore(store);
    }

    @PutMapping(path = "/{id}")
    public Store updateById(@RequestBody Store store,@PathVariable("id") Long id){
        return storeService.updateById(store,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteStore(@PathVariable("id") Long id){
        boolean ok = storeService.deleteStore(id);
        if (ok){
            return "Store delete with ID: " + id;
        }else{
            return "Could not delete store with id" + id;
        }
    }
    
}
