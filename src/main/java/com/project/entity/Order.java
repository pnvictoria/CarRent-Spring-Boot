package com.project.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class Order {
    @NonNull
    private int id;
    @NonNull
    private User user;
    @NonNull
    private Car car;
    @NonNull
    private String phone;
    @NonNull
    private State state;
}
