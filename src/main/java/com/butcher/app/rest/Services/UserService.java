package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.User;
import com.butcher.app.rest.Repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }
    public List<User> findByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }
}
