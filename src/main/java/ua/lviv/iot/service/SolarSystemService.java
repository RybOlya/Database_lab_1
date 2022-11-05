package ua.lviv.iot.service;

import ua.lviv.iot.domain.SolarSystem;

import java.util.List;

public interface SolarSystemService  extends GeneralService<SolarSystem, Integer>{
    List<SolarSystem> findByEnergySold(Integer energySold);
}
