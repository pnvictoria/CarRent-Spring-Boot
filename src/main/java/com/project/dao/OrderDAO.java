package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Order;
import com.project.entity.mapper.OrderMapper;
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
public class OrderDAO implements MainDAO<Order> {
    private static final Logger LOG = LoggerFactory.getLogger(OrderDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private final OrderMapper mapper;

    @Value("${INSERT_ORDER}")
    private String INSERT_ORDER;
    @Value("${SELECT_ALL_ORDER}")
    private String SELECT_ALL_ORDER;
    @Value("${SELECT_ORDER_BY_USER_ID}")
    private String SELECT_ORDER_BY_USER_ID;
    @Value("${UPDATE_ORDER_BY_ID}")
    private String UPDATE_ORDER_BY_ID;
    @Value("${DELETE_ORDER_BY_ID}")
    private String DELETE_ORDER_BY_ID;

    @Autowired
    public OrderDAO(JdbcTemplate jdbcTemplate, OrderMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Order obj) {
        jdbcTemplate.update(INSERT_ORDER,
                (ps -> {
                    ps.setLong(1, obj.getUser().getId());
                    ps.setString(2, obj.getPhone());
                    ps.setLong(3, obj.getCar().getId());
                    ps.setLong(4, obj.getState().getId());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_ORDER_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(Order obj) {
        jdbcTemplate.update(UPDATE_ORDER_BY_ID,
                (ps -> {
                    ps.setLong(1, obj.getState().getId());
                    ps.setLong(2, obj.getId());
                }));
    }

    @Override
    public Order getObjectById(int id) {
        return null;
    }

    @Override
    public List<Order> getObjects() {
        return null;
    }

    @Override
    public List<Order> getByItem(Order obj) {
        return null;
    }
}
