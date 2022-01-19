package com.project.entity.mapper;

import com.project.entity.Label;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LabelMapper {
    public static Label mapRow(ResultSet rs) throws SQLException {
        return Label.builder()
                .id(rs.getInt("label_id"))
                .name(rs.getString("label_name"))
                .build();
    }
}
