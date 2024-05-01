package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;

import java.util.List;

public interface IClientService {
    List<ClientDTO> findAll();
    Client save(Client client);
    Client update(Client client, Long id);
    void delete(Long id);
    Client findById(Long id);
}
