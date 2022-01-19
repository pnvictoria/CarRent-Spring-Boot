package com.project.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    private int id;
    private String name;
    private String surname;
    private boolean sex;
    private String date;
    private String email;
    private String password;
    private String avatar;
    private Role role;
}
