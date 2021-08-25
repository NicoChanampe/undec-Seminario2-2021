package com.undec.pandulce.controller;

import com.undec.pandulce.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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



}
