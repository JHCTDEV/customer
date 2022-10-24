package com.microservice.customer.domain.repositories;

import com.microservice.customer.domain.entities.CustomerTypeEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICustomerTypeRepository extends ReactiveMongoRepository<CustomerTypeEntity, String> {
}
