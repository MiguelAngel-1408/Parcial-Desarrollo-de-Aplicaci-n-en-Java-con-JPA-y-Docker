package com.proyect.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.parcial.models.Store;

public interface IStoreRepository extends JpaRepository<Store, Long> {

    
} 
