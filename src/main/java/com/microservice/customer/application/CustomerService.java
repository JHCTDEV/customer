package com.microservice.customer.application;

import com.microservice.customer.domain.entities.CustomerEntity;
import com.microservice.customer.domain.entities.CustomerTypeEntity;
import com.microservice.customer.domain.services.ICustomerExceptionService;
import com.microservice.customer.domain.services.ICustomerService;
import com.microservice.customer.domain.repositories.ICustomerRepository;
import com.microservice.customer.infrastructure.IModelMapper;
import com.microservice.customer.infrastructure.dto.CustomerDto;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IModelMapper modelMapper;
    @Autowired
    private ICustomerExceptionService customerExceptionService;

    @Override
    public Mono<ResponseDto> findAll() {
        return this.customerRepository.findAll().collectList().flatMap(listCustomerEntity -> {
            List<CustomerDto> listCustomerDto = listCustomerEntity.stream().map(customerEntity -> (CustomerDto) this.modelMapper.convert(customerEntity, CustomerDto.class)).collect(Collectors.toList());
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(listCustomerDto);
            return Mono.just(responseDto);
        });
    }

    @Override
    public Mono<ResponseDto> update(CustomerDto customerDto) {
        return this.customerRepository.findById(customerDto.getId()).flatMap(customerEntity -> {
            if (customerEntity.getId() == null)
                return Mono.error(new Exception("customer does not exist"));
            return this.customerRepository.save(customerEntity).flatMap(entity -> {
                ResponseDto responseDto = new ResponseDto();
                responseDto.setSuccess(true);
                responseDto.setData(this.modelMapper.convert(entity, CustomerDto.class));
                return Mono.just(responseDto);
            });

        }).onErrorResume(customerExceptionService::convertToDto);
    }

    @Override
    public Mono<ResponseDto> create(CustomerDto customerDto) {
        CustomerEntity customerEntity = (CustomerEntity) this.modelMapper.convert(customerDto, CustomerEntity.class);
        customerEntity.setCreateAt(new Date());
        customerEntity.setStatus("1");
        return this.customerRepository.save(customerEntity).flatMap(entity -> {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(this.modelMapper.convert(entity, CustomerDto.class));
            return Mono.just(responseDto);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.customerRepository.deleteById(id);
    }

    @Override
    public Mono<ResponseDto> findById(String id) {
        return this.customerRepository.findById(id).flatMap(customerEntity -> {
            CustomerDto customerDto = (CustomerDto) this.modelMapper.convert(customerEntity, CustomerDto.class);
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(customerDto);
            return Mono.just(responseDto);
        }).defaultIfEmpty(new ResponseDto());
    }
}

