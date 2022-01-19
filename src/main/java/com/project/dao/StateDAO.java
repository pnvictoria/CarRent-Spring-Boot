package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.State;
import com.project.entity.mapper.StateMapper;
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
public class StateDAO implements MainDAO<State> {
    private static final Logger LOG = LoggerFactory.getLogger(StateDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final StateMapper mapper;

    @Value("${INSERT_STATE}")
    private String INSERT_STATE;
    @Value("${SELECT_ALL_STATE}")
    private String SELECT_ALL_STATE;
    @Value("${SELECT_STATE_BY_ID}")
    private String SELECT_STATE_BY_ID;
    @Value("${SELECT_STATE_BY_NAME}")
    private String SELECT_STATE_BY_NAME;
    @Value("${UPDATE_STATE_BY_ID}")
    private String UPDATE_STATE_BY_ID;
    @Value("${DELETE_STATE_BY_ID}")
    private String DELETE_STATE_BY_ID;

    @Autowired
    public StateDAO(JdbcTemplate jdbcTemplate, StateMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(State obj) {
        jdbcTemplate.update(INSERT_STATE,
                (ps -> {
                    ps.setString(1, obj.getName());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_STATE_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(State obj) {
        jdbcTemplate.update(UPDATE_STATE_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getId());
                }));
    }

    @Override
    public State getObjectById(int id) {
        return null;
    }

    @Override
    public List<State> getObjects() {
        return null;
    }

    @Override
    public List<State> getByItem(State obj) {
        return null;
    }
}