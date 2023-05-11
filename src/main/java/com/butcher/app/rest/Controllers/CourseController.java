package com.butcher.app.rest.Controllers;

import com.butcher.app.rest.Models.Course;
import com.butcher.app.rest.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/courses/{id}")
    public Course getCourseById(@PathVariable long id){
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/courses/add")
    public void addCourse(@RequestBody Course course){
        courseService.saveCourse(course);
    }

    @PutMapping(value = "/courses/update/{id}")
    public void updateCourse(@PathVariable long id,@RequestBody Course course){
        Course updatedCourse = courseService.getCourse(id);
        updatedCourse.setCourseName(course.getCourseName());
        courseService.saveCourse(course);
    }

    @DeleteMapping(value = "/courses/delete/{id}")
    public void deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
    }
}
