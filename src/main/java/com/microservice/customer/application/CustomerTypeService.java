package com.microservice.customer.application;

import com.microservice.customer.domain.entities.CustomerTypeEntity;
import com.microservice.customer.domain.repositories.ICustomerTypeRepository;
import com.microservice.customer.domain.services.ICustomerExceptionService;
import com.microservice.customer.domain.services.ICustomerTypeService;
import com.microservice.customer.infrastructure.IModelMapper;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Autowired
    private IModelMapper modelMapper;
    @Autowired
    private ICustomerExceptionService customerExceptionService;
    @Override
    public Mono<ResponseDto> findAll() {
        return this.customerTypeRepository.findAll().collectList().flatMap(listCustomerTypeEntity -> {
            List<CustomerTypeDto> listCustomerTypeDto = listCustomerTypeEntity.stream().map(customerTypeEntity -> {
                return (CustomerTypeDto) this.modelMapper.convert(customerTypeEntity, CustomerTypeDto.class);
            }).collect(Collectors.toList());
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(listCustomerTypeDto);
            return Mono.just(responseDto);
        });
    }

    @Override
    public Mono<ResponseDto> update(CustomerTypeDto customerTypeDto) {
        return this.customerTypeRepository.findById(customerTypeDto.getId()).flatMap(customerTypeEntity -> {
            if (customerTypeEntity.getId() == null)
                return Mono.error(new Exception("customer type does not exist"));
            return this.customerTypeRepository.save(customerTypeEntity).flatMap(entity -> {
                ResponseDto responseDto = new ResponseDto();
                responseDto.setSuccess(true);
                responseDto.setData(this.modelMapper.convert(entity,CustomerTypeDto.class));
                return Mono.just(responseDto);
            });

        }).onErrorResume(customerExceptionService::convertToDto);
    }

    @Override
    public Mono<ResponseDto> create(CustomerTypeDto customerTypeDto) {
        CustomerTypeEntity customerTypeEntity = (CustomerTypeEntity) this.modelMapper.convert(customerTypeDto,CustomerTypeEntity.class);
        customerTypeEntity.setCreateAt(new Date());
        customerTypeEntity.setStatus("1");
        return this.customerTypeRepository.save(customerTypeEntity).flatMap(entity -> {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(this.modelMapper.convert(entity,CustomerTypeDto.class));
            return Mono.just(responseDto);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.customerTypeRepository.deleteById(id);
    }

    @Override
    public Mono<ResponseDto> findById(String id) {
        return this.customerTypeRepository.findById(id).flatMap(customerTypeEntity -> {
            CustomerTypeDto customerTypeDto = (CustomerTypeDto) this.modelMapper.convert(customerTypeEntity, CustomerTypeDto.class);
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(true);
            responseDto.setData(customerTypeDto);
            return Mono.just(responseDto);
        }).defaultIfEmpty(new ResponseDto());
    }
}
