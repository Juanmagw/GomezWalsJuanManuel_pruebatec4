package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;
import com.juanmagw.PruebaTecnica4.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    //No autenticado
    @GetMapping("/all")
    public List<ClientDTO> getRooms() {
        return clientService.findAll();
    }

    //Autenticado
    @PostMapping("/new")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/edit/{id}")
    public Client update(@RequestBody Client client, @PathVariable Long id) {
        return clientService.update(client, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    //No autenticado
    @GetMapping("/{id}") //→ Hotel en particular
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }
}

