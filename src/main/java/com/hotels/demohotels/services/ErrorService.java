package com.hotels.demohotels.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public HttpStatus getCorrectStatus(Integer code){
        return  HttpStatus.resolve(code);
    }
}
