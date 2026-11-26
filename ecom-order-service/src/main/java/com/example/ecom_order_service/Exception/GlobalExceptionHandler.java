package com.example.ecom_order_service.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MyCustomRuntimeException.class)
        public ResponseEntity<String> handleException(MyCustomRuntimeException ex){
            return ResponseEntity.status(ex.getStatusCode())
                                 .body(ex.getMessage());
        }
}
