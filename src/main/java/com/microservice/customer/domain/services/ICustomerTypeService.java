package com.microservice.customer.domain.services;


import com.microservice.customer.domain.entities.CustomerTypeEntity;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import reactor.core.publisher.Mono;

public interface ICustomerTypeService{
    Mono<ResponseDto> findAll();
    Mono<ResponseDto> create(CustomerTypeDto customerTypeDto);
    Mono<ResponseDto> update(CustomerTypeDto customerTypeDto);
    Mono<Void> delete(String id);
    Mono<ResponseDto> findById(String id);
}
