package com.example.menusecurity.service;

import com.example.menusecurity.entity.Menu;

import java.util.List;

public interface MenuService {
    public void save(Menu thmenu);
    public List<Menu> findAll();
    public Menu findById(int TheId);
    public void deleteById(int TheId);


}