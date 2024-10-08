package hanh.com.example.foodres.dao;

import hanh.com.example.foodres.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> findAllByOrderByName();
}
