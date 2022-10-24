package com.microservice.customer.infrastructure;

import com.microservice.customer.infrastructure.dto.CustomerDto;
import com.microservice.customer.infrastructure.dto.CustomerTypeDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.microservice.customer.domain.services.ICustomerService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customer")
@Log4j2
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;
    @PostMapping("save")
    public Mono<ResponseDto> create(@RequestBody CustomerDto customerDto){
        return this.customerService.create(customerDto);
    }
    @PutMapping("save")
    public Mono<ResponseDto> update(@RequestBody CustomerDto customerDto){
        return this.customerService.update(customerDto);
    }
    @GetMapping("list")
    public Mono<ResponseDto> findAll(){
        return this.customerService.findAll();
    }
    @GetMapping("get/{id}")
    public Mono<ResponseDto> getById(@PathVariable("id") String id){
        return this.customerService.findById(id);
    }
}
