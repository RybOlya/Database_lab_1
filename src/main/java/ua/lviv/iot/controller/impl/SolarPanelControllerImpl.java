/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: SolarPanelControllerImpl
 **/

package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.SolarPanelController;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.service.SolarPanelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarPanelControllerImpl implements SolarPanelController {

    private final SolarPanelService solarPanelService;

    public SolarPanelControllerImpl(SolarPanelService solarPanelService) {
        this.solarPanelService = solarPanelService;
    }


    @Override
    public Optional<SolarPanel> findByIPaddress(String ipaddress) {
        return solarPanelService.findByIPaddress(ipaddress);
    }

    @Override
    public Optional<SolarPanel> findByCurrentAngle(Integer current_angle) {
        return solarPanelService.findByCurrentAngle(current_angle);
    }

    @Override
    public List<SolarPanel> findAll() {
        return solarPanelService.findAll();
    }

    @Override
    public Optional<SolarPanel> findById(Integer id) {
        return solarPanelService.findById(id);
    }

    @Override
    public int create(SolarPanel solarPanel) {
        return solarPanelService.create(solarPanel);
    }

    @Override
    public int update(Integer id, SolarPanel solarPanel) {
        return solarPanelService.update(id, solarPanel);
    }

    @Override
    public int delete(Integer id) {
        return solarPanelService.delete(id);
    }
}
