package com.philips.university.api.dto;

import lombok.Data;

@Data
public class ScheduleOutputDTO {

    private Integer professorId;
    private Integer courseId;
    private Integer semester;
    private Integer year;
}
