package com.butcher.app.rest.Repo;

import com.butcher.app.rest.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
