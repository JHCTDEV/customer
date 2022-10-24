package com.microservice.customer.domain.repositories;

import com.microservice.customer.domain.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {
}
