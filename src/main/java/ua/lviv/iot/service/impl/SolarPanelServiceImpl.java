/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.service.impl
 * Class: SolarPanelServiceImpl
 **/

package ua.lviv.iot.service.impl;


import ua.lviv.iot.dao.SolarPanelDao;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.service.SolarPanelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarPanelServiceImpl implements SolarPanelService {
    private final SolarPanelDao solarPanelDao;

    public SolarPanelServiceImpl(SolarPanelDao solarPanelDao) {
        this.solarPanelDao = solarPanelDao;
    }


    @Override
    public List<SolarPanel> findAll() {
        return solarPanelDao.findAll();
    }

    @Override
    public Optional<SolarPanel> findById(Integer id) {
        return solarPanelDao.findById(id);
    }

    @Override
    public int create(SolarPanel solarPanel) {
        return solarPanelDao.create(solarPanel);
    }

    @Override
    public int update(Integer id, SolarPanel solarPanel) {
        return solarPanelDao.update(id, solarPanel);
    }

    @Override
    public int delete(Integer id) {
        return solarPanelDao.delete(id);
    }

    @Override
    public Optional<SolarPanel> findByIPaddress(String ipaddress) {
        return solarPanelDao.findByIPaddress(ipaddress);
    }

    @Override
    public Optional<SolarPanel> findByCurrentAngle(Integer current_angle) {
        return solarPanelDao.findByCurrentAngle(current_angle);
    }
}
