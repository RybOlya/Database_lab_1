
package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.BatteryDao;
import ua.lviv.iot.domain.Battery;
import ua.lviv.iot.domain.SolarPanel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@SuppressWarnings("SqlResolve")
@Service
public class BatteryDaoImpl implements BatteryDao {

    private static final String FIND_ALL = "SELECT * FROM battery";
    private static final String CREATE = "INSERT battery(model, capacity, ip_address_id) VALUES (?, ?, " +
            "?)";
    private static final String UPDATE = "UPDATE battery SET model=?, capacity=?, ip_address_id=? WHERE" +
            " " +
            "id=?";
    private static final String DELETE = "DELETE FROM battery WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM battery WHERE id=?";
    private static final String FIND_BY_BATTERY_IP_ADDRESS = "SELECT * FROM battery WHERE ip_address_id=?";
    private static final String FIND_BY_BATTERY_CAPACITY = "SELECT * FROM battery WHERE capacity=?";

    private final JdbcTemplate jdbcTemplate;

    public BatteryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Battery> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Battery.class));
    }

    @Override
    public Optional<Battery> findById(Integer id) {
        Optional<Battery> battery;
        try {
            battery = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Battery.class), id));
        } catch (EmptyResultDataAccessException e) {
            battery = Optional.empty();
        }
        return battery;
    }

    @Override
    public int create(Battery battery) {
        return jdbcTemplate.update(CREATE, battery.getModel(), battery.getCapacity(), battery.getIp_address_id());
    }

    @Override
    public int update(Integer id, Battery battery) {
        return jdbcTemplate.update(UPDATE, battery.getModel(), battery.getCapacity(), battery.getIp_address_id(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }


    @Override
    public Optional<Battery> findByIPaddress(Integer ipId) {
        Optional<Battery> battery;
        try {
            battery = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_BATTERY_IP_ADDRESS,
                    BeanPropertyRowMapper.newInstance(Battery.class), ipId));
        } catch (EmptyResultDataAccessException e) {
            battery = Optional.empty();
        }
        return battery;
    }

    @Override
    public Optional<Battery> findByCapacity(Integer capacity) {
        Optional<Battery> battery;
        try {
            battery = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_BATTERY_CAPACITY,
                    BeanPropertyRowMapper.newInstance(Battery.class), capacity));
        } catch (EmptyResultDataAccessException e) {
            battery = Optional.empty();
        }
        return battery;
    }
}
