package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.State;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StateService implements MainService<State> {
    @Autowired
    private MainDAO<State> daoStates;

    public StateService() {
    }

    @Override
    public boolean addObject(State obj) {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        State state = daoStates.getObjectById(obj.getId());
        if (true) {
            daoStates.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        State state = daoStates.getObjectById(id);
        if (state != null)
            daoStates.deleteObject(id);
    }

    @Override
    public void updateObject(State obj) {
        daoStates.updateObject(obj);
    }

    @Override
    public State getObjectById(int id) {
        return daoStates.getObjectById(id);
    }

    @Override
    public List<State> getObjects() {
        return daoStates.getObjects();
    }

    @Override
    public List<State> getByItem(State obj) {
        return null;
    }
}
