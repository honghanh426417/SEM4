package hanh.codelean.crudspringrestau.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import  org.springframework.web.bind.annotation.PostMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hanh.codelean.crudspringrestau.entity.Food;
import hanh.codelean.crudspringrestau.service.FoodService;

@Controller
@RequestMapping("/foods")
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService theFoodService) {
        foodService = theFoodService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listFoods(Model theModel) {

        // get foods from db
        List<Food> theFoods = foodService.findAll();

        // add to the spring model
        theModel.addAttribute("foods", theFoods);

        return "foods/list-foods";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Food theFood = new Food();

        theModel.addAttribute("food", theFood);

        return "foods/food-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("foodId") int theId,
                                    Model theModel) {

        // get the food from the service
        Food theFood = foodService.findById(theId);

        // set food as a model attribute to pre-populate the form
        theModel.addAttribute("food", theFood);

        // send over to our form
        return "foods/food-form";
    }


    @PostMapping("/save")
    public String saveFood(@ModelAttribute("food") Food theFood) {

        // save the food
        foodService.save(theFood);

        // use a redirect to prevent duplicate submissions
        return "redirect:/foods/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("foodId") int theId) {

        // delete the food
        foodService.deleteById(theId);

        // redirect to /foods/list
        return "redirect:/foods/list";

    }
}