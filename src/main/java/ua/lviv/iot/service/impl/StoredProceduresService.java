package ua.lviv.iot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.repository.CountryRepository;
import ua.lviv.iot.repository.SolarSystemRepository;

@Service
public class StoredProceduresService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    SolarSystemRepository solarSystemRepository;
    public String insertIntoCashWithdrawal(String serviceMemberName, String serviceMemberLastName,
            String vendingMachineModelName, Integer amount) {
        return ("Newly inserted row id: " + countryRepository.insertIntoCashWithdrawal(serviceMemberName,
                serviceMemberLastName, vendingMachineModelName, amount));
    }

    public String getMaxEnergySold() {
        return ("Average money income: " + solarSystemRepository.maxEnergySold());
    }
}