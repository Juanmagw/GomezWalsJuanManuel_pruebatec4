package com.juanmagw.PruebaTecnica4.controller;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;
import com.juanmagw.PruebaTecnica4.service.IClientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/allActive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all active flights found successfully"),
            @ApiResponse(responseCode = "404", description = "No active flights found")
    })
    public ResponseEntity<List<ClientDTO>> findAllActive(){
        return ResponseEntity.ok(clientService.findAllActive());
    }

    //No autenticado
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all clients found successfully"),
            @ApiResponse(responseCode = "404", description = "No clients found")
    })
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    //Autenticado
    @PostMapping("/new")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid client data")
    })
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @PutMapping("/edit/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid client data"),
            @ApiResponse(responseCode = "404", description = "Client with that id not found")
    })
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        return ResponseEntity.ok(clientService.update(clientDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Client with that id not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    //No autenticado
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found successfully"),
            @ApiResponse(responseCode = "404", description = "Client with that id not found")
    })
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
}

