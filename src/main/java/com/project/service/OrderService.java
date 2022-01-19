package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Order;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderService implements MainService<Order> {
    @Autowired
    private MainDAO<Order> daoOrder;

    public OrderService() {
    }

    @Override
    public boolean addObject(Order obj) {
        if (true) {
            daoOrder.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        daoOrder.deleteObject(id);
    }

    @Override
    public void updateObject(Order obj) {
        daoOrder.updateObject(obj);
    }

    @Override
    public Order getObjectById(int id) {
        return daoOrder.getObjectById(id);
    }

    @Override
    public List<Order> getObjects() {
        return daoOrder.getObjects();
    }

    @Override
    public List<Order> getByItem(Order obj) {
        return daoOrder.getByItem(obj);
    }
}
