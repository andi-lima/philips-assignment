package com.philips.university.domain.service;

import com.philips.university.domain.exception.CourseNotFoundException;
import com.philips.university.domain.model.Course;
import com.philips.university.domain.model.Department;
import com.philips.university.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentService departmentService;

    @Transactional
    public Course create(Course course)
    {
        Department department = departmentService.findById(course.getDepartment().getId());
        course.setDepartment(department);
        return courseRepository.save(course);
    }

    public List<Course> list()
    {
        return courseRepository.findAll();
    }

    @Transactional
    public void delete(Integer courseId)
    {
        courseRepository.delete(courseRepository.getReferenceById(courseId));
        courseRepository.flush();
    }

    public Course findById(Integer courseId)
    {
        return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
    }
}
