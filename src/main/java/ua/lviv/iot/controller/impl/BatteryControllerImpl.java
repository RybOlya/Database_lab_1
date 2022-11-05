package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.BatteryController;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.service.BatteryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatteryControllerImpl implements BatteryController {
    private final BatteryService batteryService;

    public BatteryControllerImpl(BatteryService batteryService) {
        this.batteryService = batteryService;
    }


    @Override
    public List<Battery> findAll() {
        return batteryService.findAll();
    }

    @Override
    public Optional<Battery> findById(Integer id) {
        return batteryService.findById(id);
    }

    @Override
    public int create(Battery battery) {
        return batteryService.create(battery);
    }

    @Override
    public int update(Integer id, Battery battery) {
        return batteryService.update(id, battery);
    }

    @Override
    public int delete(Integer id) {
        return batteryService.delete(id);
    }

    @Override
    public Optional<Battery> findByIPaddress(Integer IPaddressId) {
        return batteryService.findByIPaddress(IPaddressId);
    }

    @Override
    public Optional<Battery> findByCapacity(Integer capacity) {
        return batteryService.findByCapacity(capacity);
    }
}
