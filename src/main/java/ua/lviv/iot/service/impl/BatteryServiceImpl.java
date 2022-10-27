
package ua.lviv.iot.service.impl;


import ua.lviv.iot.dao.BatteryDao;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.service.BatteryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatteryServiceImpl implements BatteryService {
    private final BatteryDao batteryDao;

    public BatteryServiceImpl(BatteryDao batteryDao) {
        this.batteryDao = batteryDao;
    }


    @Override
    public List<Battery> findAll() {
        return batteryDao.findAll();
    }

    @Override
    public Optional<Battery> findById(Integer id) {
        return batteryDao.findById(id);
    }

    @Override
    public int create(Battery battery) {
        return batteryDao.create(battery);
    }

    @Override
    public int update(Integer id, Battery battery) {
        return batteryDao.update(id, battery);
    }

    @Override
    public int delete(Integer id) {
        return batteryDao.delete(id);
    }

    @Override
    public Optional<Battery> findByIPaddress(Integer IPaddressId) {
        return batteryDao.findByIPaddress(IPaddressId);
    }

    @Override
    public Optional<Battery> findByCapacity(Integer capacity) {
        return batteryDao.findByCapacity(capacity);
    }
}
