package com.okres.cashup.Service;

import com.okres.cashup.Model.Client;

import java.util.List;

/**
 * Interface with client methods required of task
 */

public interface ClientService {

    List<Client> saveClient(Client client);

    List<Client> findAllClient();

    Client findClientById(long id);

    List<Client> editClientById(long id, Client client);
}
