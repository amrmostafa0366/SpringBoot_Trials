package com.butcher.app.rest.Repo;

import com.butcher.app.rest.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
