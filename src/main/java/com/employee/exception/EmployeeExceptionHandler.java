package com.employee.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFound(EmployeeNotFoundException exception, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage =
                new ErrorMessage(exception.getMessage(), exception.getStatusCode(), httpServletRequest.getRequestURL().toString());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

/*    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFound(CityNotFoundException exception, HttpServletRequest httpServletRequest) {
        ErrorMessage errorMessage =
                new ErrorMessage(exception.getMessage(), exception.getStatusCode(), httpServletRequest.getRequestURL().toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }*/

}
