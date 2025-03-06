package com.proyect.parcial.services;

// Importing the necessary classes from the Spring Boot framework
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyect.parcial.models.Client;
import com.proyect.parcial.repositories.IClientRepository;

// Service class for the Client entity
@Service
public class ClientService {
    
    // Injecting the IClientRepository interface to interact with the database
    @Autowired
    IClientRepository clientRepository;

    // Method to get all clients from the database
    public ArrayList<Client> getClients(){
        return (ArrayList<Client>) clientRepository.findAll();
    }
    
    // Method to save a new client to the database
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    // Method to get a client by its ID
    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    // Method to update a client by its ID
    public Client updateById(Client client,long id){
        Client clientToUpdate = clientRepository.findById(id).get();
        clientToUpdate.setName(client.getName());
        clientToUpdate.setComputers(client.getComputers());
        return clientRepository.save(clientToUpdate);
    }

    // Method to delete a client by its ID
    public boolean deleteClient(Long id){
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
