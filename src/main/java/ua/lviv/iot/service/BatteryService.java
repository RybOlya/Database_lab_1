/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service
 * Interface: BatteryService
 **/

package ua.lviv.iot.service;

import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.domain.Battery;

import java.util.List;

public interface BatteryService extends GeneralService<Battery, Integer> {
    List<SolarPanel> findAllSolarPanelsBy(Integer id);
}

