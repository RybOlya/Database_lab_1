package ua.lviv.iot.service;

import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarBattery;

import java.util.List;

public interface SolarBatteryService extends GeneralService<SolarBattery, Integer>{
    public List<SolarBattery> findSolarBatteriesByIpAddressId(Integer cityId);
    void update(Integer solarBatteryId, SolarBattery uSolarBattery, Integer ipAddressId);
}
