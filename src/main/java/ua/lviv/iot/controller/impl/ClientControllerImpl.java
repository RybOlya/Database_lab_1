
package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.ClientController;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public int create(Client client) {
        return clientService.create(client);
    }

    @Override
    public int update(Integer id, Client client) {
        return clientService.update(id, client);
    }

    @Override
    public int delete(Integer id) {
        return clientService.delete(id);
    }
}
