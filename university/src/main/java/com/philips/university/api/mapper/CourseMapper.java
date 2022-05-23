package com.philips.university.api.mapper;

import com.philips.university.api.dto.CourseInputDTO;
import com.philips.university.api.dto.CourseOutputDTO;
import com.philips.university.domain.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "inputDTO.name", target = "name")
    @Mapping(source = "inputDTO.departmentId", target = "department.id")
    @Mapping(source = "inputDTO.credits", target = "credits")
    Course mapToDomainModel(CourseInputDTO inputDTO);

    @Mapping(source = "course.id", target = "id")
    @Mapping(source = "course.name", target = "name")
    @Mapping(source = "course.department.id", target = "departmentId")
    @Mapping(source = "course.credits", target = "credits")
    CourseOutputDTO mapFromDomainModel(Course course);

    List<CourseOutputDTO> mapToCollection(List<Course> courses);
}
