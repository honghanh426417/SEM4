package com.example.menusecurity.controller;


import com.example.menusecurity.entity.Menu;
import com.example.menusecurity.service.MenuService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@SpringBootApplication
@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService theMenuService) {
        menuService = theMenuService;
    }

    @GetMapping("/list")
    public String listMenu(Model model) {
        List<Menu> menuList = menuService.findAll();
        model.addAttribute("menus", menuList);
        return "menu/list-menu";
    }

    @GetMapping("/showaddmenu")
    public String showMenu(Model model) {
        Menu theMenu = new Menu();
        model.addAttribute("menu", theMenu);
        return "menu/show-add-menu";
    }


    @PostMapping("/delete")
    public String deleteMenu(@RequestParam("MenuId") int theMenuId) {
        menuService.deleteById(theMenuId);
        return "redirect:list";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("menuId") int theId, Model model) {
        Menu theMenu = menuService.findById(theId);
        model.addAttribute("menu", theMenu);
        return "menu/show-add-menu";
    }


    private static String UPLOADED_FOLDER = "src/main/resources/static/images"; // Path to static folder

    @PostMapping("/save")
    public String saveMenu(@ModelAttribute("menu") Menu theMenu,
                           @RequestParam("file") MultipartFile file,
                           Model model) {


        if (!file.isEmpty()) {
            try {

                File directory = new File(UPLOADED_FOLDER);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the file
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + File.separator + file.getOriginalFilename());
                Files.write(path, bytes);


                theMenu.setImage("/images/" + file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed: " + e.getMessage());
                return "error"; // Return to a custom error page
            }
        }


        menuService.save(theMenu);

        // Redirect to prevent duplicate submissions
        return "redirect:list";
    }
}

