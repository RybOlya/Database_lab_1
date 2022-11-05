package ua.lviv.iot.controller.impl;


import ua.lviv.iot.controller.ContactInfoController;
import ua.lviv.iot.domain.ContactInfo;
import ua.lviv.iot.service.ContactInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoControllerImpl implements ContactInfoController {
    private final ContactInfoService ContactInfoService;

    public ContactInfoControllerImpl(ContactInfoService ContactInfoService) {
        this.ContactInfoService = ContactInfoService;
    }

    @Override
    public List<ContactInfo> findAll() {
        return ContactInfoService.findAll();
    }

    @Override
    public Optional<ContactInfo> findById(Integer id) {
        return ContactInfoService.findById(id);
    }

    @Override
    public int create(ContactInfo ContactInfo) {
        return ContactInfoService.create(ContactInfo);
    }

    @Override
    public int update(Integer id, ContactInfo ContactInfo) {
        return ContactInfoService.update(id, ContactInfo);
    }

    @Override
    public int delete(Integer id) {
        return ContactInfoService.delete(id);
    }
}
