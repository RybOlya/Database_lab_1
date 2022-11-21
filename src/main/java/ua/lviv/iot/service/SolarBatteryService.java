package ua.lviv.iot.service;

import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarBattery;
import ua.lviv.iot.domain.SolarBattery;

import java.util.List;

public interface SolarBatteryService extends GeneralService<SolarBattery, Integer>{
    List<SolarBattery> findSolarBatteriesByIpAddressId(Integer cityId);
    SolarBattery create(SolarBattery entity, Integer ipAddressId, Integer solarSystemId);

    void update(Integer solarBatteryId, SolarBattery uSolarBattery,Integer ipAddressId,Integer solarSystemId);
}
