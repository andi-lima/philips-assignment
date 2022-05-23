package com.philips.university.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ProfessorInputDTO {

    @NotBlank
    private String name;

    @PositiveOrZero
    private Integer departmentId;
}
