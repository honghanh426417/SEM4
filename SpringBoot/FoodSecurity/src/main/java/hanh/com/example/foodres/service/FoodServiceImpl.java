package hanh.com.example.foodres.service;

import hanh.com.example.foodres.dao.FoodRepository;
import hanh.com.example.foodres.entities.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;
    @Autowired
    public FoodServiceImpl(FoodRepository thefoodRepository) {
        foodRepository = thefoodRepository;
    }

    @Override
    public void save(Food thefood) {
        foodRepository.save(thefood);

    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAllByOrderByName();
    }

    @Override
    public Food findById(int theId) {
        Optional<Food> result = foodRepository.findById(theId);
        Food theFood = null;
        if (result.isPresent()) {
            theFood = result.get();

        }
        else {
            throw new RuntimeException("Food not find id" + theId);
        }
        return theFood;
    }

    @Override
    public void deleteById(int id) {
        foodRepository.deleteById(id);
    }
}
