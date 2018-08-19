package com.okres.cashup.service;

import com.okres.cashup.Model.Client;

import java.util.List;

public interface ClientService {

    List<Client> saveClient(Client client);

    List<Client> findAllClient();

    Client findClientById(long id);

    List<Client> editClientById(long id, Client client);
}
