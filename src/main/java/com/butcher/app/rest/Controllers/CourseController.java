package com.butcher.app.rest.Controllers;

import com.butcher.app.rest.Models.Course;
import com.butcher.app.rest.Models.User;
import com.butcher.app.rest.Repo.CourseRepository;
import com.butcher.app.rest.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses")
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping(value = "/courses/{id}")
    public Course getCourseById(@PathVariable long id){
        return courseService.getCourseById(id);
    }

    @PostMapping(value = "/courses/add")
    public void add(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping(value = "/courses/update/{id}")
    public void update(@PathVariable long id,@RequestBody Course course){
        Course updatedCourse = courseService.getCourseById(id);
        updatedCourse.setCourseName(course.getCourseName());
        courseService.save(course);
    }

    @DeleteMapping(value = "/courses/delete/{id}")
    public void delete(@PathVariable long id){
        courseService.delete(id);
    }


}
