package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.User;
import com.butcher.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(long id){
        return userRepo.findById(id).get();
    }
    public List<User> findByFirstName(String firstName){
        return userRepo.findByFirstName(firstName);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public void deleteUserById(long id){
        userRepo.deleteById(id);
    }
}
