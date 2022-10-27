
package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.domain.SolarPanel;

import java.util.List;
import java.util.Optional;

public interface BatteryDao extends GeneralDao<Battery, Integer>  {
    Optional<Battery> findByIPaddress(Integer ipId);

    Optional<Battery> findByCapacity(Integer capacity);

}
