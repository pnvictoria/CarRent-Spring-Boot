package com.project.entity.mapper;

import com.project.entity.Car;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarMapper {
    public static Car mapRow(ResultSet rs) throws SQLException {
        return Car.builder()
                .id(rs.getInt("car_id"))
                .name(rs.getString("car_name"))
                .price(rs.getInt("car_price"))
                .jpg(rs.getString("car_jpg"))
                .level(LevelMapper.mapRow(rs))
                .label(LabelMapper.mapRow(rs))
                .desc(rs.getString("car_desc"))
                .isBlock(rs.getBoolean("car_block"))
                .build();
    }
}
