package com.philips.university.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchOutputDTO {

    private String name;
    private List<String> courses;
}
