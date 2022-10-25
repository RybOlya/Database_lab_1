/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: IPaddressDaoImpl
 **/

package ua.lviv.iot.dao.impl;


import ua.lviv.iot.dao.IPaddressDao;
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
    private static final String CREATE = "INSERT ip_address(ipAddress_name) VALUES (?)";
    private static final String UPDATE = "UPDATE ip_address SET ip_address=? WHERE ip_address=?";
    private static final String DELETE = "DELETE FROM ip_address WHERE ip_address=?";
    private static final String FIND_BY_IP_ADDRESS = "SELECT * FROM ip_address WHERE ip_address=?";

    private final JdbcTemplate jdbcTemplate;

    public IPaddressDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<IPaddress> findAll() {
        return jdbcTemplate.query(FIND_ALL,
                BeanPropertyRowMapper.newInstance(IPaddress.class));
    }

    @Override
    public Optional<IPaddress> findById(Integer ip) {
        Optional<IPaddress> ipAddress;
        try {
            ipAddress = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_IP_ADDRESS,
                    BeanPropertyRowMapper.newInstance(IPaddress.class), ip));
        } catch (EmptyResultDataAccessException e) {
            ipAddress = Optional.empty();
        }
        return ipAddress;
    }

    @Override
    public int create(IPaddress IPaddress) {
        return jdbcTemplate.update(CREATE,
                IPaddress.getIPaddress());
    }

    @Override
    public int update(Integer ip, IPaddress IPaddress) {
        return jdbcTemplate.update(UPDATE,
                IPaddress.getIPaddress(),ip);
    }

    @Override
    public int delete(Integer ip) {
        return jdbcTemplate.update(DELETE, ip);
    }
}
