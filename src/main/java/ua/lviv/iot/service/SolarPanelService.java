package ua.lviv.iot.service;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelService extends GeneralService<SolarPanel, Integer> {
    Optional<SolarPanel> findByIPaddress(Integer IPaddressId);

    Optional<SolarPanel> findByCurrentAngle(Integer currentAngle);
}
