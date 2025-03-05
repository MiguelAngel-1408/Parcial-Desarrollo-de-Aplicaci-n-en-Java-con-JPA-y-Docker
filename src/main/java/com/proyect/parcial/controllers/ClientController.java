package com.proyect.parcial.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.parcial.models.Client;
import com.proyect.parcial.services.ClientService;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @GetMapping
    public ArrayList<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @PutMapping(path = "/{id}")
    public Client updateById(@RequestBody Client client,@PathVariable("id") Long id){
        return clientService.updateById(client,id);
    }

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
