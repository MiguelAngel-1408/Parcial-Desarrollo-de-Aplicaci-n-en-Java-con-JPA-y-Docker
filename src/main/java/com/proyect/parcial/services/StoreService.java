package com.proyect.parcial.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.parcial.models.Store;
import com.proyect.parcial.repositories.IStoreRepository;

@Service
public class StoreService {

    @Autowired
    IStoreRepository storeRepository;

    public ArrayList<Store> getStores(){
        return (ArrayList<Store>) storeRepository.findAll();
    }

    public Store saveStore(Store store){
        return storeRepository.save(store);
    }

    public Optional<Store> getStoreById(Long id){
        return storeRepository.findById(id);
    }

    public Store updateById(Store store,long id){
        Store storeToUpdate = storeRepository.findById(id).get();
        storeToUpdate.setName(store.getName());
        storeToUpdate.setComputers(store.getComputers());
        return storeRepository.save(storeToUpdate);
    }

    public boolean deleteStore(Long id){
        try {
            storeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
