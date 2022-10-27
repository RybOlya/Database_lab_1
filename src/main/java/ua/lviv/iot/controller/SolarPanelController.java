package ua.lviv.iot.controller;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelController extends GeneralController<SolarPanel, Integer>{
    Optional<SolarPanel> findByIPaddress(Integer IPaddressId);

    Optional<SolarPanel> findByCurrentAngle(Integer currentAngle);
}
