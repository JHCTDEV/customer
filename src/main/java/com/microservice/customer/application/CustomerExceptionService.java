package com.microservice.customer.application;

import com.microservice.customer.domain.services.ICustomerExceptionService;
import com.microservice.customer.infrastructure.dto.ExceptionDto;
import com.microservice.customer.infrastructure.dto.ResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerExceptionService implements ICustomerExceptionService {
    @Override
    public Mono<ResponseDto> convertToDto(Throwable exception) {
        ResponseDto responseDto = new ResponseDto();
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(exception.getMessage());
        responseDto.setSuccess(false);
        responseDto.setError(exceptionDto);
        return Mono.just(responseDto);
    }
}
