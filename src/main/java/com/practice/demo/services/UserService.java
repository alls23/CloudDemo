package com.practice.demo.services;

import com.practice.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.demo.repositories.IUserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User tempUser = this.userRepository.findById(user.getId())
                .orElseThrow(EntityNotFoundException::new);
        user.setId(tempUser.getId());
        this.userRepository.save(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public static User msg() {
        System.out.println("static method");
        return null;
    }
}
