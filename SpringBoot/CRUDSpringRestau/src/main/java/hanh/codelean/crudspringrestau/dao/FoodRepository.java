package hanh.codelean.crudspringrestau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hanh.codelean.crudspringrestau.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    public List<Food> findAllByOrderByNameAsc();
}
