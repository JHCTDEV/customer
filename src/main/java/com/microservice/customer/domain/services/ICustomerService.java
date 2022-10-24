package com.microservice.customer.domain.services;

import com.microservice.customer.domain.entities.CustomerEntity;
import com.microservice.customer.infrastructure.dto.CustomerDto;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<ResponseDto> findAll();
    Mono<ResponseDto> create(CustomerDto customerDto);
    Mono<ResponseDto> update(CustomerDto customerDto);
    Mono<Void> delete(String id);
    Mono<ResponseDto> findById(String id);}
