/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: BatteryDaoImpl
 **/

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
    private static final String CREATE = "INSERT battery(model, capacity, ip_address) VALUES (?, ?, " +
            "?)";
    private static final String UPDATE = "UPDATE battery SET model=?, capacity=?, ip_address=? WHERE" +
            " " +
            "id=?";
    private static final String DELETE = "DELETE FROM battery WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM battery WHERE id=?";
    private static final String FIND_ALL_GAMES = "SELECT * FROM game WHERE EXISTS(SELECT * FROM battery_has_game  " +
            "WHERE" +
            " " +
            "game_id=id and battery_id=?)";

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
        return jdbcTemplate.update(CREATE, battery.getModel(), battery.getCapacity(), battery.getIPaddress());
    }

    @Override
    public int update(Integer id, Battery battery) {
        return jdbcTemplate.update(UPDATE, battery.getModel(), battery.getCapacity(), battery.getIPaddress(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<SolarPanel> findAllSolarPanelsBy(Integer id) {
        return jdbcTemplate.query(FIND_ALL_GAMES, BeanPropertyRowMapper.newInstance(SolarPanel.class), id);
    }
}
