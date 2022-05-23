package com.philips.university.api.controller;

import com.philips.university.api.dto.CourseInputDTO;
import com.philips.university.api.dto.CourseOutputDTO;
import com.philips.university.api.mapper.CourseMapper;
import com.philips.university.domain.model.Course;
import com.philips.university.domain.service.CourseService;
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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    private final CourseMapper courseMapper;

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseOutputDTO createCourse(@RequestBody @Valid CourseInputDTO inputDTO)
    {
        Course course = courseMapper.mapToDomainModel(inputDTO);
        return courseMapper.mapFromDomainModel(courseService.create(course));
    }

    @GetMapping("/course")
    public List<CourseOutputDTO> getCourse()
    {
        List<Course> courses = courseService.list();
        return courseMapper.mapToCollection(courses);
    }

    @DeleteMapping("/course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable Integer courseId)
    {
        courseService.delete(courseId);
    }
}
