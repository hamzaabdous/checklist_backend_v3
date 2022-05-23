package com.checklist.TA.service;

import com.checklist.TA.bo.Department;
import com.checklist.TA.bo.Function;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Optional<Department> departmentSave (Department department);
    public List<Department> findAll();
    public Optional<Department>  DeleteId(Department department);
    public Optional<Department>  UpdateDepartment(Department department);
    public long countDepartments();
}
