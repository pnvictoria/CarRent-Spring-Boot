package com.project.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class Car {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int price;
    @NonNull
    private String jpg;
    @NonNull
    private String desc;
    @NonNull
    private Label label;
    @NonNull
    private Level level;
    @NonNull
    private boolean isBlock;
}