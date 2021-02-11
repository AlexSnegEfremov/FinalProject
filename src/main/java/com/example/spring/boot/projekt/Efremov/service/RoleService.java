package com.example.spring.boot.projekt.Efremov.service;

import com.example.spring.boot.projekt.Efremov.dao.RoleDao;
import com.example.spring.boot.projekt.Efremov.modal.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    public List<Role> getListRole() {
        return roleDao.findAll();
    }
}
