package com.microservice.customer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class ModelMapper implements IModelMapper{
    @Override
    public Object convert(Object input, Type output) {
        org.modelmapper.ModelMapper  modelMapper = new org.modelmapper.ModelMapper();
        return modelMapper.map(input,output);
    }
}
