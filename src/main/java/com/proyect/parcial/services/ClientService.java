package com.proyect.parcial.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.parcial.models.Client;
import com.proyect.parcial.repositories.IClientRepository;

@Service
public class ClientService {
    
    @Autowired
    IClientRepository clientRepository;

    public ArrayList<Client> getClients(){
        return (ArrayList<Client>) clientRepository.findAll();
    }
    
    
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    public Client updateById(Client client,long id){
        Client clientToUpdate = clientRepository.findById(id).get();
        clientToUpdate.setName(client.getName());
        clientToUpdate.setComputers(client.getComputers());
        return clientRepository.save(clientToUpdate);
    }

    public boolean deleteClient(Long id){
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
