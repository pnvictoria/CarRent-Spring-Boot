package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Label;
import com.project.service.interfaces.MainService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LabelService implements MainService<Label> {

    private MainDAO<Label> daoLabels;

    public LabelService(MainDAO<Label> daoLabels) {
        this.daoLabels = daoLabels;
    }

    @Override
    public boolean addObject(Label obj) {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Label label = daoLabels.getObjectById(obj.getId());
        if (true) {
            daoLabels.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        Label label = daoLabels.getObjectById(id);
        if (label != null)
            daoLabels.deleteObject(id);
    }

    @Override
    public void updateObject(Label obj) {
        daoLabels.updateObject(obj);
    }

    @Override
    public Label getObjectById(int id) {
        return daoLabels.getObjectById(id);
    }

    @Override
    public List<Label> getObjects() {
        return daoLabels.getObjects();
    }

    @Override
    public List<Label> getByItem(Label obj) {
        return daoLabels.getByItem(obj);
    }
}
