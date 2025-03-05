package com.proyect.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.parcial.models.Client;


public interface IClientRepository extends JpaRepository<Client, Long> {

    
} 