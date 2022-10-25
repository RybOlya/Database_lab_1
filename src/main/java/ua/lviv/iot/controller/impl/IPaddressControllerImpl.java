/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.controller.impl
 * Class: IPaddressControllerImpl
 **/

package ua.lviv.iot.controller.impl;


import ua.lviv.iot.controller.IPaddressController;
import ua.lviv.iot.domain.IPaddress;
import ua.lviv.iot.service.IPaddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPaddressControllerImpl implements IPaddressController {
    private final IPaddressService IPaddressService;

    public IPaddressControllerImpl(IPaddressService IPaddressService) {
        this.IPaddressService = IPaddressService;
    }

    @Override
    public List<IPaddress> findAll() {
        return IPaddressService.findAll();
    }

    @Override
    public Optional<IPaddress> findById(Integer id) {
        return IPaddressService.findById(id);
    }

    @Override
    public int create(IPaddress IPaddress) {
        return IPaddressService.create(IPaddress);
    }

    @Override
    public int update(Integer id, IPaddress IPaddress) {
        return IPaddressService.update(id, IPaddress);
    }

    @Override
    public int delete(Integer id) {
        return IPaddressService.delete(id);
    }
}
