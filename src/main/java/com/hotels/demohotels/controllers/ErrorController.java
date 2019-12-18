package com.hotels.demohotels.controllers;

import com.hotels.demohotels.services.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ErrorController {

    private ErrorService errorService;

    public ErrorController(ErrorService errorService) {
        this.errorService = errorService;
    }

    @GetMapping("/api/v1/error")
    public ResponseEntity getError(@RequestParam Integer code) {
        log.error("Code here {}", code);
        HttpStatus httpStatus = errorService.getCorrectStatus(code);
        if (httpStatus == null) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity(httpStatus);
    }
}
