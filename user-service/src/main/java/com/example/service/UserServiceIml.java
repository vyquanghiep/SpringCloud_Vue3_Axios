package com.example.service;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceIml implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User product) {
        return userRepository.save(product);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
    @Override
    public List<User> getByKeyword(String keyword) {
        return userRepository.findByKeyword(keyword);
    }
    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }
}
