package ua.lviv.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.*;
import ua.lviv.iot.domain.SolarBattery;
import ua.lviv.iot.exception.CityNotFoundException;
import ua.lviv.iot.exception.ClientNotFoundException;
import ua.lviv.iot.exception.IpAddressNotFoundException;
import ua.lviv.iot.exception.SolarBatteryNotFoundException;
import ua.lviv.iot.repository.ClientRepository;
import ua.lviv.iot.repository.IpAddressRepository;
import ua.lviv.iot.repository.SolarBatteryRepository;
import ua.lviv.iot.service.SolarBatteryService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class SolarBatteryServiceImpl implements SolarBatteryService {
    @Autowired
    SolarBatteryRepository solarBatteryRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    IpAddressRepository ipAddressRepository;
    public SolarBattery findById(Integer id) {
        return solarBatteryRepository.findById(id)
                .orElseThrow(() -> new SolarBatteryNotFoundException(id));
    }

    public List<SolarBattery> findAll() {
        return solarBatteryRepository.findAll();
    }

    @Transactional
    public SolarBattery create(SolarBattery solarBattery) {
        solarBatteryRepository.save(solarBattery);
        return solarBattery;
    }

    @Transactional
    public void update(Integer solarBatteryId, SolarBattery uSolarBattery) {

        SolarBattery solarBattery = solarBatteryRepository.findById(solarBatteryId)
                    .orElseThrow(() -> new ClientNotFoundException(solarBatteryId));
            //update
        solarBattery.setModel(uSolarBattery.getModel());
        solarBattery.setCapacity(uSolarBattery.getCapacity());
        solarBattery.setOperatingTemperature(uSolarBattery.getOperatingTemperature());
        solarBatteryRepository.save(solarBattery);

    }

    @Override
    public List<SolarBattery> findSolarBatteriesByIpAddressId(Integer ipAddressId) {
        IpAddress ipAddress = ipAddressRepository.findById(ipAddressId)
                .orElseThrow(() -> new IpAddressNotFoundException(ipAddressId));
        return ipAddress.getSolarBatteries();
    }

    @Transactional
    public void update(Integer solarBatteryId, SolarBattery uSolarBattery, Integer ipAddressId) {
        IpAddress ipAddress = ipAddressRepository.findById(ipAddressId)
                .orElseThrow(() -> new IpAddressNotFoundException(ipAddressId));
        SolarBattery solarBattery = solarBatteryRepository.findById(solarBatteryId)
                .orElseThrow(() -> new SolarBatteryNotFoundException(solarBatteryId));
        //update
        solarBattery.setIpAddress(ipAddress);
        solarBattery.setCapacity(uSolarBattery.getCapacity());
        solarBattery.setModel(uSolarBattery.getModel());
        solarBattery.setOperatingTemperature(uSolarBattery.getOperatingTemperature());
        solarBatteryRepository.save(solarBattery);
    }

    @Transactional
    public void delete(Integer id) {
        SolarBattery solarBattery = solarBatteryRepository.findById(id)
                .orElseThrow(() -> new SolarBatteryNotFoundException(id));
        solarBatteryRepository.delete(solarBattery);
    }
}
