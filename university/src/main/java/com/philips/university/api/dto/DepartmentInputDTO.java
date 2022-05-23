package com.philips.university.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentInputDTO {

    @NotBlank
    private String name;
}
