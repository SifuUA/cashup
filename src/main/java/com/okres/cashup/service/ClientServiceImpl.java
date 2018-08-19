package com.okres.cashup.service;

import com.okres.cashup.Model.Client;
import com.okres.cashup.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation methods from client interface, layer between
 * business logic and view.
 */

@Service
public class ClientServiceImpl implements ClientService {

    @Qualifier("clientRepository")
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> saveClient(Client client) {
        clientRepository.save(client);
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(long id) {
        List<Client> clientList = clientRepository.findAll();
        for (Client c : clientList) {
            if (c.getId() == id)
                return clientRepository.findById(id);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<Client> editClientById(long id, Client client) {
        clientRepository.deleteById(id);
        clientRepository.save(client);
        return clientRepository.findAll();
    }
}
