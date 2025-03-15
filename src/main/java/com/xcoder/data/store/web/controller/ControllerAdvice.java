package com.xcoder.data.store.web.controller;

import com.xcoder.data.store.exception.SensorNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String sensorNotFoundException(SensorNotFoundException ex) {
        return "Sensor not found";
    }

    @ExceptionHandler
    public String server(Exception ex) {
        ex.printStackTrace();
        return "Something happened.";
    }
}
