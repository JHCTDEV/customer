package com.microservice.customer.application;

import com.microservice.customer.domain.CustomerEntity;
import com.microservice.customer.domain.customerService;
import com.microservice.customer.domain.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class customerCrud implements customerService {
    @Autowired
    private customerRepository customerRepository;
    @Override
    public Flux<CustomerEntity> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Mono<CustomerEntity> save(CustomerEntity customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.customerRepository.deleteById(id);
    }

    @Override
    public Mono<CustomerEntity> findById(String id) {
        return this.customerRepository.findById(id);
    }
}
