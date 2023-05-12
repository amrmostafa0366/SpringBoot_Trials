package com.butcher.app.rest.Controllers;


import com.butcher.app.rest.Models.Course;
import com.butcher.app.rest.Models.Department;
import com.butcher.app.rest.Models.User;
import com.butcher.app.rest.Services.CourseService;
import com.butcher.app.rest.Services.DepartmentService;
import com.butcher.app.rest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = {"", "/"})
    public String welcome() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/users/firstName/{firstName}")
    public List<User> getUserByName(@PathVariable String firstName){
        return userService.findByFirstName(firstName);
    }

    @PostMapping(value = "/users/add")
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(value = "/users/update/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userService.getUserById(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        userService.save(updatedUser);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }



    @PostMapping("/users/{userId}/courses/{courseId}")
    public void assignCourseToUser(@PathVariable long userId, @PathVariable long courseId) {
        User user = userService.getUserById(userId);
        Course course = courseService.getCourseById(courseId);
        user.getCourses().add(course);
        course.getUsers().add(user);

        userService.save(user);
        courseService.save(course);
    }

    @PostMapping(value = "/users/{userId}/departments/{departmentId}")
    public void assignDepartmentToUser(@PathVariable long userId, @PathVariable long departmentId){
        User user = userService.getUserById(userId);
        Department department = departmentService.getDepartmentById(departmentId);
        user.setDepartment(department);
        department.getUsers().add(user);

        userService.save(user);
        departmentService.save(department);
    }
}
