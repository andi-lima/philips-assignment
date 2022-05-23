package com.philips.university.domain.exception;

public class DepartmentNotFoundException extends RuntimeException {

    public static final String MSG = "Department with ID %d not found.";

    public DepartmentNotFoundException(String message)
    {
        super(message);
    }

    public DepartmentNotFoundException(Integer departmentId)
    {
        this(String.format(MSG, departmentId));
    }
}
