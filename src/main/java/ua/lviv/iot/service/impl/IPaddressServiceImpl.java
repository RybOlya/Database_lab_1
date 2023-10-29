package ua.lviv.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.IpAddress;
import ua.lviv.iot.exception.IpAddressNotFoundException;
import ua.lviv.iot.exception.SolarExistForIpAddressException;
import ua.lviv.iot.repository.IpAddressRepository;
import ua.lviv.iot.repository.ClientRepository;
import ua.lviv.iot.service.IpAddressService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class IpAddressServiceImpl implements IpAddressService {
    @Autowired
    IpAddressRepository ipAddressRepository;

    @Autowired
    ClientRepository clientRepository;

    public IpAddress findById(Integer id) {
        return ipAddressRepository.findById(id)
                .orElseThrow(() -> new IpAddressNotFoundException(id));
    }

    public List<IpAddress> findAll() {
        return ipAddressRepository.findAll();
    }

    @Transactional
    public IpAddress create(IpAddress ipAddress) {

        return new IpAddress() {
            {
                setId(ipAddress.getId());
                setIpAddress(ipAddressRepository.insertIntoIpAddress(ipAddress.getId(), ipAddress.getIpAddress()));
            }
        };
    }

    @Transactional
    public void update(Integer id, IpAddress uIpAddress) {
        IpAddress ipAddress = ipAddressRepository.findById(id)
                .orElseThrow(() -> new IpAddressNotFoundException(id));
        //update
        ipAddress.setIpAddress(uIpAddress.getIpAddress());
        ipAddressRepository.save(ipAddress);
    }

    @Transactional
    public void delete(Integer id) {
        IpAddress ipAddress = ipAddressRepository.findById(id)
                .orElseThrow(() -> new IpAddressNotFoundException(id));
        if (!ipAddress.getSolarBatteries().isEmpty()&&!ipAddress.getSolarBatteries().isEmpty()) throw new SolarExistForIpAddressException(id);
        ipAddressRepository.delete(ipAddress);
    }
    @Override
    public void insertTenRowsInIpAddress() {
        ipAddressRepository.insertTenRowsInIpAddress();
    }
}
