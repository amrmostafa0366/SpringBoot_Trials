package com.butcher.app.rest.Controllers;

import com.butcher.app.rest.Models.Department;
import com.butcher.app.rest.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/departments")
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getDepartmentById(@PathVariable long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping(value = "/departments/add")
    public void add(@RequestBody Department department){
        departmentService.save(department);
    }

    @PutMapping(value = "departments/update/{id}")
    public void update(@PathVariable long id , @RequestBody Department department){
        Department  updatedDepartment = departmentService.getDepartmentById(id);
        updatedDepartment.setDepartmentName(department.getDepartmentName());
        departmentService.save(updatedDepartment);
    }

    @DeleteMapping(value = "/departments/delete/{id}")
    public void delete(@PathVariable long id){
        departmentService.delete(id);
    }
}
