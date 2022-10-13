package com.microservice.customer.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface customerService {
    Flux<CustomerEntity> findAll();
    Mono<CustomerEntity> save(CustomerEntity customer);
    Mono<Void> delete(String id);
    Mono<CustomerEntity> findById(String id);
}
