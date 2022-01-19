package com.project.entity.mapper;

import com.project.entity.Level;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LevelMapper {
    public static Level mapRow(ResultSet rs) throws SQLException {
        return Level.builder()
                .id(rs.getInt("level_id"))
                .name(rs.getString("level_name"))
                .build();
    }
}
