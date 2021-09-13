package ar.edu.undec.tpseminario2.controller;

//TOMADOR DE EXCEPCIONES

import ar.edu.undec.tpseminario2.dto.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "ar.edu.undec.tpseminario2.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handlerException(Exception e){
        Response response = new Response(999,e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
