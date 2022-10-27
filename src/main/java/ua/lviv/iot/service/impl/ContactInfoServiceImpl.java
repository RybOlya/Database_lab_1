package ua.lviv.iot.service.impl;


import ua.lviv.iot.dao.ContactInfoDao;
import ua.lviv.iot.domain.ContactInfo;
import ua.lviv.iot.service.ContactInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoDao ContactInfoDao;

    public ContactInfoServiceImpl(ContactInfoDao ContactInfoDao) {
        this.ContactInfoDao = ContactInfoDao;
    }

    @Override
    public List<ContactInfo> findAll() {
        return ContactInfoDao.findAll();
    }

    @Override
    public Optional<ContactInfo> findById(Integer id) {
        return ContactInfoDao.findById(id);
    }

    @Override
    public int create(ContactInfo contactInfo) {
        return ContactInfoDao.create(contactInfo);
    }

    @Override
    public int update(Integer id, ContactInfo contactInfo) {
        return ContactInfoDao.update(id, contactInfo);
    }

    @Override
    public int delete(Integer id) {
        return ContactInfoDao.delete(id);
    }

}
