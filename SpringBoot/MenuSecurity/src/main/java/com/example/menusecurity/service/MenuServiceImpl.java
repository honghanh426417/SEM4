package com.example.menusecurity.service;

import com.example.menusecurity.dao.MenuRepository;
import com.example.menusecurity.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    @Autowired
    public MenuServiceImpl(MenuRepository theMenuRepository) {
        menuRepository = theMenuRepository;
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAllByOrderByName();
    }

    @Override
    public void save(Menu themenu){
        menuRepository.save(themenu);
    }

    @Override
    public Menu findById(int theId) {
        Optional<Menu> result = menuRepository.findById(theId);
        Menu theMenu = null;
        if (result.isPresent()) {
            theMenu = result.get();

        }
        else {
            throw new RuntimeException("Menu not find id" + theId);
        }
        return theMenu;
    }

    @Override
    public void deleteById(int id) {
        menuRepository.deleteById(id);
    }
}
