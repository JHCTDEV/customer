package com.microservice.customer.infrastructure;

import com.microservice.customer.domain.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.microservice.customer.domain.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customer")
public class Controller {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CustomerEntity> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping(value = "get/{id}")
    Mono<CustomerEntity> findById(@PathVariable("id") String id){
        return this.customerService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return this.customerService.delete(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerEntity> save(@RequestBody CustomerEntity customer){
        return this.customerService.save(customer);

    }
}
