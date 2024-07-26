package hanh.com.example.foodres.service;

import hanh.com.example.foodres.entities.Food;

import java.util.List;

public interface FoodService {
    public void save(Food thefood);
    public List<Food> findAll();
    public Food findById(int TheId);
    public void deleteById(int TheId);

}
