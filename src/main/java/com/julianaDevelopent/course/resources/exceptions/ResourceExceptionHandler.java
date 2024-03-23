package com.julianaDevelopent.course.resources.exceptions;

import com.julianaDevelopent.course.services.exceptions.DatabaseException;
import com.julianaDevelopent.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice   // serve para interceptar as exceçoes para q esse obj possa excecutar o possivel tratamento
public class ResourceExceptionHandler extends RuntimeException{
    @ExceptionHandler(ResourceNotFoundException.class) // essa notaçao serve para indicar q esse metodo e para pegar o erro e interceptar e tratar as exceçoes q estao aqui dentro
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e , HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error , e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class) // essa notaçao serve para indicar q esse metodo e para pegar o erro e interceptar e tratar as exceçoes q estao aqui dentro
    public ResponseEntity<StandardError> database(ResourceNotFoundException e , HttpServletRequest request){
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error , e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
