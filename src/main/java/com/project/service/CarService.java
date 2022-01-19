package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Car;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarService implements MainService<Car> {
    @Autowired
    private MainDAO<Car> daoCars;

    public CarService() {
    }

    @Override
    public boolean addObject(Car obj) {
        //изменить проверку, сделать проверку полностью по обьекту или логину
        Car car = daoCars.getObjectById(obj.getId());
        if (true) {
            daoCars.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
       daoCars.deleteObject(id);
    }

    @Override
    public void updateObject(Car obj) {
        daoCars.updateObject(obj);
    }

    @Override
    public Car getObjectById(int id) {
        return daoCars.getObjectById(id);
    }

    @Override
    public List<Car> getObjects() {
        return daoCars.getObjects();
    }

    @Override
    public List<Car> getByItem(Car obj) {
        return daoCars.getByItem(obj);
    }
}
