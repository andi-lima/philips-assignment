package com.philips.university.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ExceptionMessageBuilder {

    private Integer status;
    private String errorMessage;
    private OffsetDateTime timestamp;
}
