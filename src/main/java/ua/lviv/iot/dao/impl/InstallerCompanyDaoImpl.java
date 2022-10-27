
package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.InstallerCompanyDao;
import ua.lviv.iot.domain.InstallerCompany;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@SuppressWarnings("SqlResolve")
@Service
public class InstallerCompanyDaoImpl implements InstallerCompanyDao {
    private static final String FIND_ALL = "SELECT * FROM installer_company";
    private static final String CREATE = "INSERT installer_company(name,contact_info_id,area_coverage ) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE installer_company SET name=?, contact_info_id=?,area_coverage=? WHERE id=?";
    private static final String DELETE = "DELETE FROM installer_company WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM installer_company WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    public InstallerCompanyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<InstallerCompany> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(InstallerCompany.class));
    }

    @Override
    public Optional<InstallerCompany> findById(Integer id) {
        Optional<InstallerCompany> installerCompany;
        try {
            installerCompany = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(InstallerCompany.class), id));
        } catch (EmptyResultDataAccessException e) {
            installerCompany = Optional.empty();
        }
        return installerCompany;
    }

    @Override
    public int create(InstallerCompany installerCompany) {
        return jdbcTemplate.update(CREATE,installerCompany.getName(), installerCompany.getContact_info_id(),
         installerCompany.getArea_coverage());
    }

    @Override
    public int update(Integer id, InstallerCompany installerCompany) {
        return jdbcTemplate.update(UPDATE,installerCompany.getName(), installerCompany.getContact_info_id(),
                installerCompany.getArea_coverage(),id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
