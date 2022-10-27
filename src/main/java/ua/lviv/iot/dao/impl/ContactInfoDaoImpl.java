package ua.lviv.iot.dao.impl;


import ua.lviv.iot.dao.ContactInfoDao;
import ua.lviv.iot.domain.ContactInfo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ContactInfoDaoImpl implements ContactInfoDao {
    private static final String FIND_ALL = "SELECT * FROM contact_info";
    private static final String CREATE = "INSERT contact_info(contact_info) VALUES (?)";
    private static final String UPDATE = "UPDATE contact_info SET contact_info=? WHERE id=?";
    private static final String DELETE = "DELETE FROM contact_info WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM contact_info WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    public ContactInfoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<ContactInfo> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ContactInfo.class));
    }

    @Override
    public Optional<ContactInfo> findById(Integer id) {
        Optional<ContactInfo> contact;
        try {
            contact = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(ContactInfo.class), id));
        } catch (EmptyResultDataAccessException e) {
            contact = Optional.empty();
        }
        return contact;
    }

    @Override
    public int create(ContactInfo contact) {
        return jdbcTemplate.update(CREATE,contact.getPhone(),contact.getEmail());
    }

    @Override
    public int update(Integer id, ContactInfo contact) {
        return jdbcTemplate.update(UPDATE,contact.getPhone(),contact.getEmail(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
