package ua.lviv.iot.dao.impl;


import ua.lviv.iot.dao.IPaddressDao;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.IPaddress;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class IPaddressDaoImpl implements IPaddressDao {
    private static final String FIND_ALL = "SELECT * FROM ip_address";
    private static final String CREATE = "INSERT ip_address(ip_address) VALUES (?)";
    private static final String UPDATE = "UPDATE ip_address SET ip_address=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ip_address WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM ip_address WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    public IPaddressDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<IPaddress> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(IPaddress.class));
    }

    @Override
    public Optional<IPaddress> findById(Integer id) {
        Optional<IPaddress> ip;
        try {
            ip = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(IPaddress.class), id));
        } catch (EmptyResultDataAccessException e) {
            ip = Optional.empty();
        }
        return ip;
    }

    @Override
    public int create(IPaddress ip) {
        return jdbcTemplate.update(CREATE,ip.getIp_address());
    }

    @Override
    public int update(Integer id, IPaddress ip) {
        return jdbcTemplate.update(UPDATE,ip.getIp_address(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
