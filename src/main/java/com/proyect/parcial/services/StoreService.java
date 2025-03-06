package com.proyect.parcial.services;

// Importing the necessary classes from the Spring Boot framework
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyect.parcial.models.Store;
import com.proyect.parcial.repositories.IStoreRepository;


// Service class for the Store entity
@Service
public class StoreService {

    // Injecting the IStoreRepository interface to interact with the database
    @Autowired
    IStoreRepository storeRepository;

    // Method to get all stores from the database
    public ArrayList<Store> getStores(){
        return (ArrayList<Store>) storeRepository.findAll();
    }

    // Method to save a new store to the database
    public Store saveStore(Store store){
        return storeRepository.save(store);
    }


    // Method to get a store by its ID
    public Optional<Store> getStoreById(Long id){
        return storeRepository.findById(id);
    }


    // Method to update a store by its ID
    public Store updateById(Store store,long id){
        Store storeToUpdate = storeRepository.findById(id).get();
        storeToUpdate.setName(store.getName());
        storeToUpdate.setComputers(store.getComputers());
        return storeRepository.save(storeToUpdate);
    }

    // Method to delete a store by its ID
    public boolean deleteStore(Long id){
        try {
            storeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
