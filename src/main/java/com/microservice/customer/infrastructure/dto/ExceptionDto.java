package com.microservice.customer.infrastructure.dto;

import lombok.Data;

@Data
public class ExceptionDto {
    private Integer code;
    private String message;
}
