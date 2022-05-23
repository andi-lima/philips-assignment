package com.philips.university.api.exception;

import com.philips.university.domain.exception.DepartmentNotFoundException;
import com.philips.university.domain.exception.ProfessorNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionMessageBuilder exceptionMessage = ExceptionMessageBuilder
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage(exception.getMessage())
                .timestamp(OffsetDateTime.now())
                .build();

        return this.handleExceptionInternal(exception, exceptionMessage, headers, status, request);
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    public ResponseEntity handleProfessorNotFoundException(ProfessorNotFoundException exception, WebRequest request)
    {
        ExceptionMessageBuilder exceptionMessage = ExceptionMessageBuilder
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage(exception.getMessage())
                .timestamp(OffsetDateTime.now())
                .build();

        return handleExceptionInternal(exception, exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity handleDepartmentNotFoundException(DepartmentNotFoundException exception, WebRequest request)
    {
        ExceptionMessageBuilder exceptionMessage = ExceptionMessageBuilder
                .builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorMessage(exception.getMessage())
                .timestamp(OffsetDateTime.now())
                .build();

        return handleExceptionInternal(exception, exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
