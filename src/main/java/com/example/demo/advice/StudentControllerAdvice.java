package com.example.demo.advice;

import com.example.demo.BusinessLogicException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*** 
 * @ControllerAdvice is global exception handler for all the controllers in project
 *
 * class should extend ResponseEntityExceptionHandler to override the method of native exception
 * and can also have handel of custom business exception with the exception pass as parameter and in the
 * @ExceptionHandler annotation.
 *
 *
 * */

@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (ex.getMessage().contains("age should "))
            return new ResponseEntity<>("age of student should be between 6 to 40", HttpStatus.BAD_REQUEST);
        else if (ex.getMessage().contains("email"))
            return new ResponseEntity<>("invalid email", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>("not a valid body", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<Object> handleMyBusinessLogicException(BusinessLogicException ex) {
        return new ResponseEntity<>("its a  businessException", HttpStatus.FORBIDDEN);
    }


}
