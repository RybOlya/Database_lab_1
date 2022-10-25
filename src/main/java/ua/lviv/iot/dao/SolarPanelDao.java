/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao
 * Interface: SolarPanelDao
 **/

package ua.lviv.iot.dao;

import ua.lviv.iot.domain.SolarPanel;

import java.util.Optional;

public interface SolarPanelDao extends GeneralDao<SolarPanel, Integer>{
    Optional<SolarPanel> findByIPaddress(String ipaddress);

    Optional<SolarPanel> findByCurrentAngle(Integer current_angle);
}
