package com.microservice.customer.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
public class CustomerEntity {
    @Id
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
