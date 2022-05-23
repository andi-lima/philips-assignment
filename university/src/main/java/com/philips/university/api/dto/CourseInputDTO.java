package com.philips.university.api.dto;

import lombok.Data;

@Data
public class CourseInputDTO {

    private String name;
    private Integer departmentId;
    private Integer credits;
}
