package com.project.entity.mapper;

import com.project.entity.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper {

    public static User mapRow(ResultSet rs) throws SQLException {
        return User.builder()
                .id(rs.getInt("user_id"))
                .name(rs.getString("user_name"))
                .surname(rs.getString("user_surname"))
                .sex(rs.getBoolean("user_sex"))
                .date(rs.getString("user_date"))
                .email(rs.getString("user_email"))
                .password(rs.getString("user_password"))
                .avatar(rs.getString("user_avatar"))
                .role(RoleMapper.mapRow(rs))
                .build();
    }
}
