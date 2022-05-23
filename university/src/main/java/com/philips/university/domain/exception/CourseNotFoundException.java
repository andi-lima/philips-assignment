package com.philips.university.domain.exception;

public class CourseNotFoundException extends RuntimeException {

    public static final String MSG = "Course with ID %d not found.";

    public CourseNotFoundException(String message)
    {
        super(message);
    }

    public CourseNotFoundException(Integer courseId)
    {
        this(String.format(MSG, courseId));
    }
}
