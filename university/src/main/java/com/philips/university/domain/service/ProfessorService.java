package com.philips.university.domain.service;

import com.philips.university.domain.exception.ProfessorNotFoundException;
import com.philips.university.domain.model.Department;
import com.philips.university.domain.model.Professor;
import com.philips.university.domain.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DepartmentService departmentService;

    @Transactional
    public Professor create(Professor professor)
    {
        Department department = departmentService.findById(professor.getDepartment().getId());
        professor.setDepartment(department);
        return professorRepository.save(professor);
    }

    public List<Professor> list()
    {
        return professorRepository.findAll();
    }

    @Transactional
    public void delete(Integer professorId)
    {
        professorRepository.delete(professorRepository.getReferenceById(professorId));
        professorRepository.flush();
    }

    public Professor findById(Integer professorId)
    {
        return professorRepository.findById(professorId)
                .orElseThrow(() -> new ProfessorNotFoundException(professorId));
    }
}
