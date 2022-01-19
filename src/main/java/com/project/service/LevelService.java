package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Level;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LevelService implements MainService<Level> {
    @Autowired
    private MainDAO<Level> daoLevels;

    public LevelService() {
    }

    @Override
    public boolean addObject(Level obj) {
//         TODO: изменить проверку, сделать проверку полностью по обьекту или имени
//        Level level = daoLevels.getByItem(obj.getId());
        if (true) {
            daoLevels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        Level level = daoLevels.getObjectById(id);
        if (level != null)
            daoLevels.deleteObject(id);
    }

    @Override
    public void updateObject(Level obj) {
        daoLevels.updateObject(obj);
    }

    @Override
    public Level getObjectById(int id) {
        return daoLevels.getObjectById(id);
    }

    @Override
    public List<Level> getObjects() {
        return daoLevels.getObjects();
    }

    @Override
    public List<Level> getByItem(Level obj) {
        return null;
    }
}
