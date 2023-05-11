package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.Course;
import com.butcher.app.rest.Repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Course getCourse(long id){
        return courseRepo.findById(id).get();
    }

    public void saveCourse(Course course){
        courseRepo.save(course);
    }

    public void deleteCourse(long id){
        courseRepo.deleteById(id);
    }
}
