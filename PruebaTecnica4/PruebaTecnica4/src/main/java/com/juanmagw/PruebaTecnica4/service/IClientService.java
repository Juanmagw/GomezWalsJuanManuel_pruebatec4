package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;

import java.util.List;

public interface IClientService {
    List<ClientDTO> findAllActive();
    List<ClientDTO> findAll();
    ClientDTO save(Client client);
    ClientDTO update(ClientDTO clientDTO, Long id);
    void delete(Long id);
    ClientDTO findById(Long id);
}
