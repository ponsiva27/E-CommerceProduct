package com.example.ProductService.ControllerAdviser;

import com.example.ProductService.DTOs.ErrormessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrormessageDTO>  ArithmeticException(){
         ErrormessageDTO error = new ErrormessageDTO();
         error.setMessage("Arithmetic Exception in the code");

        ResponseEntity<ErrormessageDTO> response = new ResponseEntity<>
                (error, HttpStatus.BAD_REQUEST);

        return response;
    }

            @ExceptionHandler(TimeoutException.class)
        public ResponseEntity<ErrormessageDTO> timeoutError(){
            ErrormessageDTO error = new ErrormessageDTO();
            error.setMessage("Timeout Error");

            ResponseEntity<ErrormessageDTO> response = new ResponseEntity<>
                    (error, HttpStatus.REQUEST_TIMEOUT);

            return response;

        }

}
