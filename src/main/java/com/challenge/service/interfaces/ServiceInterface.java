package com.challenge.service.interfaces;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface ServiceInterface<T> {
    T save(T object);
}
