package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.User;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements MainService<User> {
    @Autowired
    private MainDAO<User> daoUser;

    public UserService() {
    }

    @Override
    public boolean addObject(User obj) {
        //TODO: изменить проверку, сделать проверку полностью по обьекту или логину
//        User user = daoUser.getObjectById(obj.getId());
//        if (user == null) {
        if (true) {
            daoUser.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        User user = daoUser.getObjectById(id);
        if (user != null)
            daoUser.deleteObject(id);
    }

    @Override
    public void updateObject(User obj) {
        daoUser.updateObject(obj);
    }

    @Override
    public User getObjectById(int id) {
        return daoUser.getObjectById(id);
    }

    @Override
    public List<User> getObjects() {
        return daoUser.getObjects();
    }

    @Override
    public List<User> getByItem(User obj) {
        return daoUser.getByItem(obj);
    }
}
