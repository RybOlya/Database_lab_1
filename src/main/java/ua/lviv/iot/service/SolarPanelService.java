package ua.lviv.iot.service;


import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarPanel;

import java.util.List;


public interface SolarPanelService extends GeneralService<SolarPanel, Integer>{

    SolarPanel create(SolarPanel entity, Integer ipAddressId,Integer solarSystemId);

    void update(Integer solarPanelId, SolarPanel uSolarPanel,Integer ipAddressId,Integer solarSystemId);
    List<SolarPanel> findSolarPanelsByIpAddressId(Integer ipAddressId);
}
