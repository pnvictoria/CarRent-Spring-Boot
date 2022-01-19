package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Role;
import com.project.entity.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:properties/sqlQueries.properties")
public class RoleDAO implements MainDAO<Role> {
    private static final Logger LOG = LoggerFactory.getLogger(RoleDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final OrderMapper mapper;

    @Value("${INSERT_ROLE}")
    private String INSERT_ROLE;
    @Value("${SELECT_ALL_ROLE}")
    private String SELECT_ALL_ROLE;
    @Value("${SELECT_ROLE_BY_ID}")
    private String SELECT_ROLE_BY_ID;
    @Value("${SELECT_ROLE_BY_NAME}")
    private String SELECT_ROLE_BY_NAME;
    @Value("${UPDATE_ROLE_BY_ID}")
    private String UPDATE_ROLE_BY_ID;
    @Value("${DELETE_ROLE_BY_ID}")
    private String DELETE_ROLE_BY_ID;

    @Autowired
    public RoleDAO(JdbcTemplate jdbcTemplate, OrderMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Role obj) {
        jdbcTemplate.update(INSERT_ROLE,
                (ps -> {
                    ps.setString(1, obj.getName());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_ROLE_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(Role obj) {
        jdbcTemplate.update(UPDATE_ROLE_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getId());
                }));
    }

    @Override
    public Role getObjectById(int id) {
        return null;
    }

    @Override
    public List<Role> getObjects() {
        return null;
    }

    @Override
    public List<Role> getByItem(Role obj) {
        return null;
    }
}
