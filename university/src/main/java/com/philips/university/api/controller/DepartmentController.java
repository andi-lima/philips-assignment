package com.philips.university.api.controller;

import com.philips.university.api.dto.DepartmentInputDTO;
import com.philips.university.api.dto.DepartmentOutputDTO;
import com.philips.university.api.mapper.DepartmentMapper;
import com.philips.university.domain.model.Department;
import com.philips.university.domain.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/university")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final DepartmentMapper departmentMapper;

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentOutputDTO createDepartment(@RequestBody @Valid DepartmentInputDTO inputDTO)
    {
        Department department = departmentMapper.mapToDomainModel(inputDTO);
        return departmentMapper.mapFromDomainModel(departmentService.create(department));
    }

    @GetMapping("/department")
    public List<DepartmentOutputDTO> getDepartment()
    {
        List<Department> departments = departmentService.listDepartments();
        return departmentMapper.mapToCollection(departments);

    }

    @DeleteMapping("/department/{departmentId}")
    public void deleteDepartment(@PathVariable Integer departmentId)
    {
        /* Tenha certeza que o departamento não está em uso antes de deletar */

        departmentService.delete(departmentId);

    }
}
