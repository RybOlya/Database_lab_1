package ua.lviv.iot.service;
import ua.lviv.iot.domain.Battery;
import java.util.Optional;

public interface BatteryService extends GeneralService<Battery, Integer> {
    Optional<Battery> findByIPaddress(Integer IPaddressId);

    Optional<Battery> findByCapacity(Integer capacity);
}

