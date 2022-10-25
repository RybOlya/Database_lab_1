/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller
 * Interface: SolarPanelController
 **/

package ua.lviv.iot.controller;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelController extends GeneralController<SolarPanel, Integer>{
    Optional<SolarPanel> findByIPaddress(String ipaddress);

    Optional<SolarPanel> findByCurrentAngle(Integer currentAngle);
}
