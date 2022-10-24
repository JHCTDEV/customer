package com.microservice.customer.infrastructure;

import java.lang.reflect.Type;

public interface IModelMapper {
    Object convert(Object input, Type output);
}
