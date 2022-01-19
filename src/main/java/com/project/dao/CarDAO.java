package com.project.dao;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Car;
import com.project.entity.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:properties/sqlQueries.properties")
public class CarDAO implements MainDAO<Car> {
    private final JdbcTemplate jdbcTemplate;
    private final CarMapper mapper;

    @Value("${INSERT_CAR}")
    private String INSERT_CAR;
    @Value("${SELECT_ALL_CARS}")
    private String SELECT_ALL_CARS;
    @Value("${SELECT_CAR_BY_ID}")
    private String SELECT_CAR_BY_ID;
    @Value("${SELECT_CAR_BY_NAME}")
    private String SELECT_CAR_BY_NAME;
    @Value("${UPDATE_CAR_BY_ID}")
    private String UPDATE_CAR_BY_ID;
    @Value("${DELETE_CAR_BY_ID}")
    private String DELETE_CAR_BY_ID;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate, CarMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    @Override
    public void addObject(Car obj) {
        jdbcTemplate.update(INSERT_CAR,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getPrice());
                    ps.setString(3, obj.getJpg());
                    ps.setLong(4, obj.getLevel().getId());
                    ps.setLong(5, obj.getLabel().getId());
                    ps.setString(6, obj.getDesc());
                }));
    }

    @Override
    public void deleteObject(int id) {
        jdbcTemplate.update(DELETE_CAR_BY_ID,
                (ps -> {
                    ps.setLong(1, id);
                }));
    }

    @Override
    public void updateObject(Car obj) {
        jdbcTemplate.update(UPDATE_CAR_BY_ID,
                (ps -> {
                    ps.setString(1, obj.getName());
                    ps.setLong(2, obj.getPrice());
                    ps.setString(3, obj.getJpg());
                    ps.setLong(4, obj.getLevel().getId());
                    ps.setLong(5, obj.getLabel().getId());
                    ps.setString(6, obj.getDesc());
                    ps.setLong(7, obj.getId());
                }));
    }

    @Override
    public Car getObjectById(int id) {
        return null;
    }

    @Override
    public List<Car> getObjects() {
//        return jdbcTemplate.query(SELECT_ALL_CARS, mapper);
        return null;
    }

    @Override
    public List<Car> getByItem(Car obj) {
//        return jdbcTemplate.query(SELECT_CAR_BY_NAME, new Object[]{
//                obj.getName()
//        }, mapper);
        return null;
    }
}
