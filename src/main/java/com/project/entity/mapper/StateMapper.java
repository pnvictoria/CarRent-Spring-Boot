package com.project.entity.mapper;

import com.project.entity.State;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateMapper {
    public static State mapRow(ResultSet rs) throws SQLException {
        return State.builder()
                .id(rs.getInt("state_id"))
                .name(rs.getString("state_name"))
                .build();
    }
}
