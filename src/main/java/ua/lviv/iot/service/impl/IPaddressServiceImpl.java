/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service.impl
 * Class: IPaddressServiceImpl
 **/

package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.IPaddressDao;
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
    public int create(IPaddress IPaddress) {
        return IPaddressDao.create(IPaddress);
    }

    @Override
    public int update(Integer id, IPaddress IPaddress) {
        return IPaddressDao.update(id, IPaddress);
    }

    @Override
    public int delete(Integer id) {
        return IPaddressDao.delete(id);
    }
}
