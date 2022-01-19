package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Label;
import com.project.entity.mapper.LabelMapper;
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
public class LabelDAO implements MainDAO<Label> {
    private static final Logger LOG = LoggerFactory.getLogger(LabelDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final LabelMapper mapper;

    @Value("${INSERT_LABEL}")
    private String INSERT_LABEL;
    @Value("${SELECT_ALL_LABEL}")
    private String SELECT_ALL_LABEL;
    @Value("${SELECT_LABEL_BY_ID}")
    private String SELECT_LABEL_BY_ID;
    @Value("${SELECT_LABEL_BY_NAME}")
    private String SELECT_LABEL_BY_NAME;
    @Value("${UPDATE_LABEL_BY_ID}")
    private String UPDATE_LABEL_BY_ID;
    @Value("${DELETE_LABEL_BY_ID}")
    private String DELETE_LABEL_BY_ID;

    @Autowired
    public LabelDAO(JdbcTemplate jdbcTemplate, LabelMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Label obj) {
        jdbcTemplate.update(INSERT_LABEL,
                (ps -> {
                    ps.setString(1, obj.getName());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_LABEL_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(Label obj) {
        jdbcTemplate.update(UPDATE_LABEL_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getId());
                }));
    }

    @Override
    public Label getObjectById(int id) {
        return null;
    }

    @Override
    public List<Label> getObjects() {
        return null;
    }

    @Override
    public List<Label> getByItem(Label obj) {
        return null;
    }
}
