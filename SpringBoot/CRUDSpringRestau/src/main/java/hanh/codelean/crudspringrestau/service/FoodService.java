package hanh.codelean.crudspringrestau.service;

import java.util.List;

import hanh.codelean.crudspringrestau.entity.Food;

public interface FoodService {
    public List<Food> findAll();
    public Food findById(int theId);
    public void save(Food theFood);
    public void deleteById(int theId);
}
