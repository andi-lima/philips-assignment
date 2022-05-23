package com.philips.university.domain.service;

import com.philips.university.domain.exception.DepartmentNotFoundException;
import com.philips.university.domain.model.Department;
import com.philips.university.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department create(Department department)
    {
        department = departmentRepository.save(department);

        return department;
    }

    public List<Department> listDepartments()
    {
        return departmentRepository.findAll();
    }

    @Transactional
    public void delete(Integer departmentId)
    {
        departmentRepository.delete(departmentRepository.getReferenceById(departmentId));
        departmentRepository.flush();
    }

    public Department findById(Integer departmentId)
    {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new DepartmentNotFoundException(departmentId));
    }
}
