package com.microservice.customer.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CustomerEntity {
    @Id
    private int id;
    private String documentNumber;
    private String documentType;
    private String customerType;
    private String telephone;
    private String address;
    private String name;
    private String email;
    private Boolean status;
}
