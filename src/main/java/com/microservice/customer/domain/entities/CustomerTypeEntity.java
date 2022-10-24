package com.microservice.customer.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customerType")
@Data
public class CustomerTypeEntity {
    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;
    private String status;
}
