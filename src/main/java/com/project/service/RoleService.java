package com.project.service;

import com.project.dao.interfaces.MainDAO;
import com.project.entity.Role;
import com.project.service.interfaces.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoleService implements MainService<Role> {
    @Autowired
    private MainDAO<Role> daoRoles;

    public RoleService() {
    }

    @Override
    public boolean addObject(Role obj) {
        //изменить проверку, сделать проверку полностью по обьекту или имени
        Role role = daoRoles.getObjectById(obj.getId());
        if (true) {
            daoRoles.addObject(obj);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteObject(int id) {
        Role role = daoRoles.getObjectById(id);
        if (role != null)
            daoRoles.deleteObject(id);
    }

    @Override
    public void updateObject(Role obj) {
        daoRoles.updateObject(obj);
    }

    @Override
    public Role getObjectById(int id) {
        return daoRoles.getObjectById(id);
    }

    @Override
    public List<Role> getObjects() {
        return daoRoles.getObjects();
    }

    @Override
    public List<Role> getByItem(Role obj) {
        return null;
    }
}
