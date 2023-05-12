package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.Department;
import com.butcher.app.rest.Repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(long id){
        return departmentRepository.findById(id).get();
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public void delete(long id){
        departmentRepository.deleteById(id);
    }
}
