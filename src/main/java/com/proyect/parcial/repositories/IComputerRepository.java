package com.proyect.parcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.parcial.models.Computer;

public interface IComputerRepository extends JpaRepository<Computer, Long> {

    
} 
