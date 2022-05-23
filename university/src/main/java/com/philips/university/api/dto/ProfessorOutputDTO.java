package com.philips.university.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorOutputDTO {

    private Integer id;
    private String name;
    private Integer departmentId;
}
