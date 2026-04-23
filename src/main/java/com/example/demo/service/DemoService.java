package com.example.demo.service;

import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final UserRepository userRepository;

    public DemoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
    }

    public User update(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow();

        existingUser.setName(user.getName());

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
