package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    UserRepository userRepository;
	
	@GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) {

    	User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

    	user.setFirstName(userDetails.getFirstName());
    	user.setLastName(userDetails.getLastName());
    	user.setCountry(userDetails.getCountry());
    	user.setEmail(userDetails.getEmail());
    	user.setGender(userDetails.getGender());
    	user.setDob(userDetails.getDob());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
