package com.okres.cashup.Controller;

import com.okres.cashup.Model.Client;
import com.okres.cashup.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(@Qualifier("clientRepository") ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(value = ("/all"), method = RequestMethod.GET)
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Client> create(@RequestBody Client client) {
        clientRepository.save(client);
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable("id") long clientId) {
        List<Client> clientList = clientRepository.findAll();
        if (clientId > clientList.size())
            throw new IllegalArgumentException();
        return clientRepository.findById(clientId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public List<Client> editClient(@PathVariable("id") long clientId,
                                   @RequestBody Client newClient) {
        clientRepository.deleteById(clientId);
        clientRepository.save(newClient);
//        Client client = clientRepository.findByInn(newClient.getInn());
//        client.setId(clientId);
//        System.out.println(clientRepository.findByInn(newClient.getInn()));
        return clientRepository.findAll();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badExceptionHandler() {
    }

}
