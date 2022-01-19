package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.User;
import com.project.entity.mapper.UserMapper;
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
public class UserDAO implements MainDAO<User> {
    private static final Logger LOG = LoggerFactory.getLogger(UserDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper mapper;

    @Value("${INSERT_USER}")
    private String INSERT_USER;
    @Value("${SELECT_ALL_USERS}")
    private String SELECT_ALL_USERS;
    @Value("${SELECT_USER_BY_ID}")
    private String SELECT_USER_BY_ID;
    @Value("${UPDATE_USER_BY_ID}")
    private String UPDATE_USER_BY_ID;
    @Value("${DELETE_USER_BY_ID}")
    private String DELETE_USER_BY_ID;
    @Value("${SELECT_USER_BY_EMAIL}")
    private String SELECT_USER_BY_EMAIL;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate, UserMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(User obj) {
        jdbcTemplate.update(INSERT_USER,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setString(2, obj.getSurname());
                    ps.setBoolean(3, obj.isSex());
                    ps.setString(4, obj.getDate());
                    ps.setString(5, obj.getEmail());
                    ps.setString(6, obj.getPassword());
                    ps.setString(7, "avatar.png");
                    ps.setLong(8, obj.getRole().getId());
                    ps.setBoolean(9, false);
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(User obj) {
        jdbcTemplate.update(UPDATE_USER_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setString(2, obj.getSurname());
                    ps.setBoolean(3, obj.isSex());
                    ps.setString(4, obj.getDate());
                    ps.setString(5, obj.getEmail());
                    ps.setString(6, obj.getPassword());
                    ps.setString(7, obj.getAvatar());
                    ps.setLong(8, obj.getRole().getId());
                    ps.setLong(9, obj.getId());
                }));
    }

    @Override
    public User getObjectById(int id) {
        return null;
    }

    @Override
    public List<User> getObjects() {
        return null;
    }

    @Override
    public List<User> getByItem(User obj) {
        return null;
    }
}
