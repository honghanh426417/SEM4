package hanh.com.example.userManager.service;
import hanh.com.example.userManager.entities.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(int theId);
    public void save(User theUser);
    public void deleteById(int TheId);
    List<User> findByName(String name);
}