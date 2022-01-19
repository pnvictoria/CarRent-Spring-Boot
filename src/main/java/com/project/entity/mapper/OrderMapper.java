package com.project.entity.mapper;

import com.project.entity.Order;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper {
    public static Order mapRow(ResultSet rs) throws SQLException {
        return Order.builder()
                .id(rs.getInt("order_id"))
                .user(UserMapper.mapRow(rs))
                .car(CarMapper.mapRow(rs))
                .phone(rs.getString("order_phone"))
                .state(StateMapper.mapRow(rs))
                .build();
    }
}
