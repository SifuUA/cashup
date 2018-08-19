package com.okres.cashup.Controller;

import com.okres.cashup.Model.Client;
import com.okres.cashup.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = ("/all"), method = RequestMethod.GET)
    public List<Client> getAll() {
        return this.clientService.findAllClient();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Client> create(@RequestBody Client client) {
        this.clientService.saveClient(client);
        return clientService.findAllClient();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable("id") long clientId) {
     return clientService.findClientById(clientId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public List<Client> editClient(@PathVariable("id") long clientId,
                                   @RequestBody Client newClient) {
        return clientService.editClientById(clientId, newClient);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badExceptionHandler() {
    }
}
