package com.demo.swagger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.swagger.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final Map<Long, String> users = new HashMap<>();

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
        

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<String>> getAllUsers() {
        return ResponseEntity.ok(new ArrayList<>(users.values()));
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public ResponseEntity<String> createUser(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Username") 
    										 @org.springframework.web.bind.annotation.RequestBody String username) {
        long id = users.size() + 1;
        users.put(id, username);
        return ResponseEntity.ok("User created with ID: " + id+" and user name: "+username);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody String username) {
        if (users.containsKey(id)) {
            users.put(id, username);
            return ResponseEntity.ok("User updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (users.remove(id) != null) {
            return ResponseEntity.ok("User deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
