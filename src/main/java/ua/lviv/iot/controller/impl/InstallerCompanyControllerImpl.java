package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.InstallerCompanyController;
import ua.lviv.iot.domain.InstallerCompany;
import ua.lviv.iot.service.InstallerCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstallerCompanyControllerImpl implements InstallerCompanyController {
    private final InstallerCompanyService installerCompanyService;

    public InstallerCompanyControllerImpl(InstallerCompanyService installerCompanyService) {
        this.installerCompanyService = installerCompanyService;
    }

    @Override
    public List<InstallerCompany> findAll() {
        return installerCompanyService.findAll();
    }

    @Override
    public Optional<InstallerCompany> findById(Integer id) {
        return installerCompanyService.findById(id);
    }

    @Override
    public int create(InstallerCompany installerCompany) {
        return installerCompanyService.create(installerCompany);
    }

    @Override
    public int update(Integer id, InstallerCompany installerCompany) {
        return installerCompanyService.update(id, installerCompany);
    }

    @Override
    public int delete(Integer id) {
        return installerCompanyService.delete(id);
    }
}
