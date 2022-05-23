package com.philips.university.domain.exception;

public class ProfessorNotFoundException extends RuntimeException {

    public static final String MSG = "Professor with ID %d not found.";

    public ProfessorNotFoundException(String message)
    {
        super(message);
    }

    public ProfessorNotFoundException(Integer professorId)
    {
        this(String.format(MSG, professorId));
    }
}
