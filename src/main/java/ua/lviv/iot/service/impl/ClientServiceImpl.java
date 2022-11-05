package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.ClientDao;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientDao.findById(id);
    }

    @Override
    public int create(Client client) {
        return clientDao.create(client);
    }

    @Override
    public int update(Integer id, Client client) {
        return clientDao.update(id, client);
    }

    @Override
    public int delete(Integer id) {
        return clientDao.delete(id);
    }
}