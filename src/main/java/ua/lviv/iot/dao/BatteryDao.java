/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao
 * Interface: Battery
 **/

package ua.lviv.iot.dao;

import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.domain.SolarPanel;

import java.util.List;

public interface BatteryDao extends GeneralDao<Battery, Integer>  {
    List<SolarPanel> findAllSolarPanelsBy(Integer id);

}
