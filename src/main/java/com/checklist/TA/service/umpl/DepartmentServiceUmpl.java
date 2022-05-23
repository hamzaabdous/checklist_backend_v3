package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.Department;
import com.checklist.TA.repository.DepartmentRepository;
import com.checklist.TA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceUmpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> departmentSave(Department department) {
        Date currentDate = new Date();
        department.setCreatedDate(currentDate);
        return Optional.ofNullable(departmentRepository.save(department));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> DeleteId(Department department) {
        departmentRepository.deleteById(department.getId());
        return Optional.ofNullable(department);
    }

    @Override
    public Optional<Department> UpdateDepartment(Department department) {
        Date currentDate = new Date();
        department.setUpdateDate(currentDate);
        return Optional.ofNullable(departmentRepository.save(department));
    }

    @Override
    public long countDepartments() {
        return departmentRepository.count();
    }
}
