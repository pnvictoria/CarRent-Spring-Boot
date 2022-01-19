package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Level;
import com.project.entity.mapper.LevelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
@PropertySource("classpath:properties/sqlQueries.properties")
public class LevelDAO implements MainDAO<Level> {
    private static final Logger LOG = LoggerFactory.getLogger(LevelDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final LevelMapper mapper;

    @Value("${INSERT_LABEL}")
    private String INSERT_LEVEL;
    @Value("${SELECT_ALL_LEVEL}")
    private String SELECT_ALL_LEVEL;
    @Value("${SELECT_LEVEL_BY_ID}")
    private String SELECT_LEVEL_BY_ID;
    @Value("${SELECT_LEVEL_BY_NAME}")
    private String SELECT_LEVEL_BY_NAME;
    @Value("${UPDATE_LEVEL_BY_ID}")
    private String UPDATE_LEVEL_BY_ID;
    @Value("${DELETE_LEVEL_BY_ID}")
    private String DELETE_LEVEL_BY_ID;

    @Autowired
    public LevelDAO(JdbcTemplate jdbcTemplate, LevelMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Level obj) {
        jdbcTemplate.update(INSERT_LEVEL,
                (ps -> {
                    ps.setString(1, obj.getName());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_LEVEL_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(Level obj) {
        jdbcTemplate.update(UPDATE_LEVEL_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getId());
                }));
    }

    @Override
    public Level getObjectById(int id) {
        return null;
    }

    @Override
    public List<Level> getObjects() {
        return null;
    }

    @Override
    public List<Level> getByItem(Level obj) {
        return null;
    }
}