package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.ClientDao;
import ua.lviv.iot.dao.IPaddressDao;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.IPaddress;
import ua.lviv.iot.service.IPaddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IPaddressServiceImpl implements IPaddressService {
    private final IPaddressDao IPaddressDao;

    public IPaddressServiceImpl(IPaddressDao IPaddressDao) {
        this.IPaddressDao = IPaddressDao;
    }

    @Override
    public List<IPaddress> findAll() {
        return IPaddressDao.findAll();
    }

    @Override
    public Optional<IPaddress> findById(Integer id) {
        return IPaddressDao.findById(id);
    }

    @Override
    public int create(IPaddress ipaddress) {
        return IPaddressDao.create(ipaddress);
    }

    @Override
    public int update(Integer id, IPaddress ipaddress) {
        return IPaddressDao.update(id, ipaddress);
    }

    @Override
    public int delete(Integer id) {
        return IPaddressDao.delete(id);
    }

}
