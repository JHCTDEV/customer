package com.microservice.customer.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {
}
