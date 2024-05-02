package com.juanmagw.PruebaTecnica4.service;

import com.juanmagw.PruebaTecnica4.dto.ClientDTO;
import com.juanmagw.PruebaTecnica4.model.Client;
import com.juanmagw.PruebaTecnica4.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findAllActive(){
        return clientRepository.findAll().stream().filter(room -> !room.getIsDeleted()).map(ClientService::getClientDTOFromClient).toList();
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientService::getClientDTOFromClient).toList();
    }

    @Override
    public ClientDTO save(Client client) {
        if (findById(client.getId()) == null) {
            client.setIsDeleted(false);
            return getClientDTOFromClient(clientRepository.save(client));
        }else{
            return null;
        }
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO, Long id) {
        Client clientAux = clientRepository.findById(id).orElse(null);
        if(clientAux != null) {
            clientAux.setName(clientDTO.getName());
            clientAux.setSurname(clientDTO.getSurname());
            clientAux.setEmail(clientDTO.getEmail());
            return getClientDTOFromClient(clientRepository.save(clientAux));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setIsDeleted(true);
            clientRepository.save(client);
        }
    }

    @Override
    public ClientDTO findById(Long id) {
        return getClientDTOFromClient(clientRepository.findById(id).orElse(null));
    }

    public static ClientDTO getClientDTOFromClient(Client client){
        ClientDTO clientDTO = new ClientDTO();
        if (client != null) {
            clientDTO.setName(client.getName());
            clientDTO.setSurname(client.getSurname());
            clientDTO.setEmail(client.getEmail());
            return clientDTO;
        }else {
            return null;
        }
    }

    public static Client getClientFromClientDTO(ClientDTO clientDTO){
        Client client = new Client();
        if (clientDTO != null){
            client.setName(clientDTO.getName());
            client.setSurname(clientDTO.getSurname());
            client.setEmail(clientDTO.getEmail());
            return client;
        }else{
            return null;
        }
    }
}
