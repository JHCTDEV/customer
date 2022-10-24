package com.microservice.customer.infrastructure;

import com.microservice.customer.domain.entities.CustomerTypeEntity;
import com.microservice.customer.domain.services.ICustomerTypeService;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
@RequestMapping("customerType")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;
    @PostMapping("save")
    public Mono<ResponseDto> create(@RequestBody CustomerTypeDto customerTypeDto){
        return this.customerTypeService.create(customerTypeDto);
    }
    @PutMapping("save")
    public Mono<ResponseDto> update(@RequestBody CustomerTypeDto customerTypeDto){
        return this.customerTypeService.update(customerTypeDto);
    }
    @GetMapping("list")
    public Mono<ResponseDto> findAll(){
        return this.customerTypeService.findAll();
    }
    @GetMapping("get/{id}")
    public Mono<ResponseDto> getById(@PathVariable("id") String id){
        return this.customerTypeService.findById(id);
    }
}
