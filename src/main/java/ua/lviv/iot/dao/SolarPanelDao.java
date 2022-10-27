
package ua.lviv.iot.dao;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelDao extends GeneralDao<SolarPanel, Integer>{
    Optional<SolarPanel> findByIPaddress(Integer ipId);

    Optional<SolarPanel> findByCurrentAngle(Integer currentAngle);
}
