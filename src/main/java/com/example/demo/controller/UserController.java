package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}
