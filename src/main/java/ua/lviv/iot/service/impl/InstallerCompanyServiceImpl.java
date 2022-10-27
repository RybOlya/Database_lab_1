package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.InstallerCompanyDao;
import ua.lviv.iot.domain.InstallerCompany;
import ua.lviv.iot.service.InstallerCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstallerCompanyServiceImpl implements InstallerCompanyService {

    private final InstallerCompanyDao installerCompanyDao;

    public InstallerCompanyServiceImpl(InstallerCompanyDao installerCompanyDao) {
        this.installerCompanyDao = installerCompanyDao;
    }

    @Override
    public List<InstallerCompany> findAll() {
        return installerCompanyDao.findAll();
    }

    @Override
    public Optional<InstallerCompany> findById(Integer id) {
        return installerCompanyDao.findById(id);
    }

    @Override
    public int create(InstallerCompany installerCompany) {
        return installerCompanyDao.create(installerCompany);
    }

    @Override
    public int update(Integer id, InstallerCompany installerCompany) {
        return installerCompanyDao.update(id, installerCompany);
    }

    @Override
    public int delete(Integer id) {
        return installerCompanyDao.delete(id);
    }
}