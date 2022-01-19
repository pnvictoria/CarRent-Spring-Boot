package com.project.entity.mapper;

import com.project.entity.Role;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleMapper {
    public static Role mapRow(ResultSet rs) throws SQLException {
        return Role.builder()
                .id(rs.getInt("role_id"))
                .name(rs.getString("role_name"))
                .build();
    }
}
