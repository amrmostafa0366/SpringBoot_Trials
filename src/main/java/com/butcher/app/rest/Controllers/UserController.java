package com.butcher.app.rest.Controllers;


import com.butcher.app.rest.Models.User;
import com.butcher.app.rest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"" , "/"})
    public String welcome(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users/add")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping(value = "/users/update/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userService.getUserById(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        userService.saveUser(updatedUser);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }


}
