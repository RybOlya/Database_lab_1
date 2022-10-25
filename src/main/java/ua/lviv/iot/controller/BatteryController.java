/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller
 * Interface: BatteryController
 **/

package ua.lviv.iot.controller;

import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.domain.Battery;

import java.util.List;

public interface BatteryController extends GeneralController<Battery, Integer>  {
    List<SolarPanel> findAllSolarPanelsBy(Integer id);
}
