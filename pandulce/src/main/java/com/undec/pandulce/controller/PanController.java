package com.undec.pandulce.controller;

import com.undec.pandulce.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/panes")
public class PanController {

    @GetMapping()
    public ResponseEntity<Response> list(){
        Response response = new Response();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable String id){
        Response response = new Response();
        response.setStatus(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
