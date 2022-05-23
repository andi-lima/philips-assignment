package com.philips.university.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Search {

    private String name;
    private List<String> courses;
}
