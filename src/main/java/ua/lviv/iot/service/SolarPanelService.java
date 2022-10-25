/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service
 * Interface: SolarPanelService
 **/

package ua.lviv.iot.service;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelService extends GeneralService<SolarPanel, Integer> {
    Optional<SolarPanel> findByIPaddress(String ipaddress);

    Optional<SolarPanel> findByCurrentAngle(Integer current_angle);
}
