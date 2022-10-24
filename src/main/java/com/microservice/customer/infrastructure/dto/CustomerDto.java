package com.microservice.customer.infrastructure.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class CustomerDto {
    private String id;
    private String documentNumber;
    private String documentType;
    private String customerType;
    private String telephone;
    private String address;
    private String name;
    private String email;
    private String status;
}
