package com.example.ktcrud.service;

import com.example.ktcrud.entity.User;
import com.example.ktcrud.repository.UserRepository;
import com.example.ktcrud.request.dto.UserCreate;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(UserCreate userCreate) throws ParseException {
        User user = new User();
        user.setUsername(userCreate.getUsername());
        user.setFirstname(userCreate.getFirstName());
        user.setLastname(userCreate.getLastName());
        user.setPassword(userCreate.getPassword());
        user.setEmail(userCreate.getEmail());
        user.setDelete(true);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        user.setBrithDay(dateFormat.parse(userCreate.getBrithDay()));
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public User updateUser(User user) {
        try {
            User existingUser = userRepository.findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("User Not Found"));
            existingUser.setUsername(user.getUsername());
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setBrithDay(user.getBrithDay());
            existingUser.setEmail(user.getEmail());
            existingUser.setDelete(user.isDelete());
            return userRepository.save(user);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public User deleteUser(User user) {
        try {
            User existingUser = userRepository.findById(user.getId())
                    .orElseThrow(() -> new RuntimeException("User Not Found"));
            existingUser.setDelete(user.isDelete());
            return userRepository.save(existingUser);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
