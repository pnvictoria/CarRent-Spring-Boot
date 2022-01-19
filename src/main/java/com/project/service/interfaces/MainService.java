package com.project.service.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface MainService<T> {
    boolean addObject(T obj);

    void deleteObject(int id);

    void updateObject(T obj);

    T getObjectById(int id);

    List<T> getObjects();

    List<T> getByItem(T obj);
}
