package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;
import com.juanmagw.PruebaTecnica4.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(this::getClientDTOFromClient).collect(Collectors.toList());
    }

    @Override
    public Client save(Client client) {
        if (findById(client.getId()) == null) {
            client.setIsDeleted(false);
            return clientRepository.save(client);
        }else{
            return null;
        }
    }

    @Override
    public Client update(Client client, Long id) {
        Client clientAux = findById(id);
        if(clientAux != null) {
            clientAux.setName(client.getName());
            clientAux.setSurname(client.getSurname());
            clientAux.setEmail(client.getEmail());
            clientAux.setBookingFlights(client.getBookingFlights());
            clientAux.setBookingRooms(client.getBookingRooms());
            return clientRepository.save(clientAux);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Client client = findById(id);
        client.setIsDeleted(true);
        clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientDTO getClientDTOFromClient(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setBookingFlights(client.getBookingFlights());
        clientDTO.setBookingRooms(client.getBookingRooms());
        return clientDTO;
    }
}
