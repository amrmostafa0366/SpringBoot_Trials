package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.Course;
import com.butcher.app.rest.Repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getCourseById(long id){
        return courseRepository.findById(id).get();
    }

    public void save(Course course){
        courseRepository.save(course);
    }

    public void delete(long id){
        courseRepository.deleteById(id);
    }
}
