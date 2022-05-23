package com.checklist.TA.controller;

import com.checklist.TA.bo.Department;
import com.checklist.TA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Optional<Department> add(@RequestBody Department department){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return departmentService.departmentSave(department);

    }

    @GetMapping("/")
    public List<Department> findAll(){
        List<Department> departments= departmentService.findAll();
        return departments;
    }

    @PostMapping("/delete/{id}")
    public Optional<Department> DeleteId(@PathVariable("id") Department department){
        return departmentService.DeleteId(department);
    }

    @PutMapping("/update")
    public Optional<Department>  UpdateDepartment(@RequestBody Department department){
        return departmentService.UpdateDepartment(department);
    }

    @GetMapping("/count")
    public Long countDepartments(){
        return departmentService.countDepartments();
    }
}
