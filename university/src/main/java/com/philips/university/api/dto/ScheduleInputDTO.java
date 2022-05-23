package com.philips.university.api.dto;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class ScheduleInputDTO {

    @PositiveOrZero
    private Integer professorId;

    @PositiveOrZero
    private Integer courseId;

    @PositiveOrZero
    private Integer semester;

    @PositiveOrZero
    private Integer year;
}
