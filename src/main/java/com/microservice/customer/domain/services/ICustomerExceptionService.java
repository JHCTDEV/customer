package com.microservice.customer.domain.services;

import com.microservice.customer.infrastructure.dto.ResponseDto;
import reactor.core.publisher.Mono;

public interface ICustomerExceptionService {
    Mono<ResponseDto> convertToDto(Throwable exception);
}
