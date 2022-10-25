/**
 * @author @liosyk
 * Project name: DataBase4
 * Package name: kyiv.harvard.lois.dao.impl
 * Class: ClientDaoImpl
 **/

package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.ClientDao;
import ua.lviv.iot.domain.Client;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service
public class ClientDaoImpl implements ClientDao {
    private static final String FIND_ALL = "SELECT * FROM client";
    private static final String CREATE = "INSERT client(surname,name,password,is_a_company) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE client SET surname=?, name=?,password=?, is_a_company=? WHERE id=?";
    private static final String DELETE = "DELETE FROM client WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM client WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    public ClientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Client.class));
    }

    @Override
    public Optional<Client> findById(Integer id) {
        Optional<Client> client;
        try {
            client = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Client.class), id));
        } catch (EmptyResultDataAccessException e) {
            client = Optional.empty();
        }
        return client;
    }

    @Override
    public int create(Client client) {
        return jdbcTemplate.update(CREATE,client.getSurname(), client.getName(), client.getPassword(), client.getIs_a_company());
    }

    @Override
    public int update(Integer id, Client client) {
        return jdbcTemplate.update(UPDATE,client.getSurname(), client.getName(), client.getPassword(),
                client.getIs_a_company(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
