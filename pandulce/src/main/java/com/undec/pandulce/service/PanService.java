package com.undec.pandulce.service;

import com.undec.pandulce.dto.Response;
import com.undec.pandulce.entity.PanesEntity;
import com.undec.pandulce.repository.PanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanService {

    @Autowired
    private PanesRepository panesRepository;

    public PanService(PanesRepository panesRepository) {
        this.panesRepository = panesRepository;
    }

    public Response findAll(){
        Response thisResponse = new Response();
        try {
            List<PanesEntity> panesList = panesRepository.findAll();
            thisResponse.setData(panesList);
        }catch (Exception e){

        }
        return thisResponse;
    }
}
