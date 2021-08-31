package com.undec.pandulce.service;

import com.undec.pandulce.dto.Response;
import org.springframework.stereotype.Service;

@Service
public class PanService {

    public Response findAll(){
        Response thisResponse = new Response();
        try {
            thisResponse.setStatus(2);
        }catch (Exception e){

        }
        return thisResponse;
    }
}
