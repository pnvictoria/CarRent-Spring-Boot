package com.project.dao.dto;

import com.project.dao.interfaces.FilterDAO;
import com.project.dto.CarFilterDTO;
import com.project.entity.Car;
import com.project.entity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
@PropertySource("classpath:properties/sqlQueries.properties")
public class CarFilterDAO implements FilterDAO<Car, CarFilterDTO> {
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper mapper;

    @Value("${SELECT_BY_CAR_DTO}")
    private String SELECT_BY_CAR_DTO;

    @Autowired
    public CarFilterDAO(JdbcTemplate jdbcTemplate, UserMapper mapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }
    @Override
    public List<Car> getFilteredObjects(CarFilterDTO dto) {
        jdbcTemplate.update(SELECT_BY_CAR_DTO,
                (ps -> {
                    ps.setString(1, dto.getName());
                    ps.setString(2, dto.getName());
                    setNullOrInt(ps,3, dto.getLevelId());
                    setNullOrInt(ps, 4, dto.getLevelId());
                    setNullOrInt(ps, 5, dto.getLabelId());
                    setNullOrInt(ps, 6, dto.getLabelId());
                    ps.setInt(7, dto.getPriceFrom());
                    ps.setInt(8, dto.getPriceTo());
                    ps.setInt(9, dto.getPriceFrom());
                    ps.setInt(10, dto.getPriceTo());
                }));
        //TODO:must return list
        return null;
    }

    public void setNullOrInt(PreparedStatement ps, int index,Integer value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }
}
