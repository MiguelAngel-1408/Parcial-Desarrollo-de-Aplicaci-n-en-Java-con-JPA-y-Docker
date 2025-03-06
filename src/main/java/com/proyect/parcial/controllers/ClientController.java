package com.proyect.parcial.controllers;

// Java
import java.util.ArrayList;
import java.util.Optional;

// Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyect.parcial.models.Client;
import com.proyect.parcial.services.ClientService;

// Controller for Client
@RestController
@RequestMapping("/client")
public class ClientController {

    // Service for Client
    @Autowired
    private ClientService clientService;
    
    // Get all clients
    @GetMapping
    public ArrayList<Client> getClients(){
        return clientService.getClients();
    }

    // Save a client
    @PostMapping
    public Client saveClient(@RequestBody Client client){
        return this.clientService.saveClient(client);
    }

    // Get a client by ID
    @GetMapping(path = "/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    // Update a client by ID
    @PutMapping(path = "/{id}")
    public Client updateById(@RequestBody Client client,@PathVariable("id") Long id){
        return clientService.updateById(client,id);
    }


    // Delete a client by ID
    @DeleteMapping(path = "/{id}")
    public String deleteClient(@PathVariable("id") Long id){
        boolean ok = clientService.deleteClient(id);
        if (ok){
            return "Client delete with ID: " + id;
        }else{
            return "Could not delete client with id" + id;
        }
    }
    
}
