package hanh.codelean.crudspringrestau.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanh.codelean.crudspringrestau.dao.FoodRepository;
import hanh.codelean.crudspringrestau.entity.Food;

@Service
public class FoodServiceFd implements FoodService{
    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceFd(FoodRepository theFoodRepository) { foodRepository = theFoodRepository;}

    @Override
    public List<Food> findAll() { return foodRepository.findAllByOrderByNameAsc();}

    @Override
    public Food findById(int theId) {
        Optional<Food> result = foodRepository.findById(theId);

        Food theFood = null;

        if (result.isPresent()) {
            theFood = result.get();
        }
        else {
            throw  new RuntimeException("Did not find food id -  " + theId);
        }
        return theFood;
    }
    @Override
    public void save(Food theFood) {
        foodRepository.save(theFood);
    }

    @Override
    public void deleteById(int theId) {
        foodRepository.deleteById(theId);
    }
}
