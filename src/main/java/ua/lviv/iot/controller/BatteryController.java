
package ua.lviv.iot.controller;

import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.domain.Battery;

import java.util.List;
import java.util.Optional;

public interface BatteryController extends GeneralController<Battery, Integer>  {
    Optional<Battery> findByIPaddress(Integer IPaddressId);

    Optional<Battery> findByCapacity(Integer capacity);
}
