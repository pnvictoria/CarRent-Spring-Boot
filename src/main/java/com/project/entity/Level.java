package com.project.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class Level {
    @NonNull
    private int id;
    @NonNull
    private String name;
}
