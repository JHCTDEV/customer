package com.microservice.customer.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface customerRepository extends ReactiveMongoRepository<CustomerEntity, String> {
}
