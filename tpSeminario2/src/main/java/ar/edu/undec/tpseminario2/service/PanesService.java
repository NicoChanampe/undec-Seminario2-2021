package ar.edu.undec.tpseminario2.service;

import ar.edu.undec.tpseminario2.dto.Response;
import ar.edu.undec.tpseminario2.entity.Panes;
import ar.edu.undec.tpseminario2.repository.PanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanesService {
    @Autowired
    private PanesRepository panesRepository;

    public PanesService(PanesRepository panesRepository) {
        this.panesRepository = panesRepository;
    }

    public Response findAll(){
        Response thisResponse = new Response();
        try {
            List<Panes> panesList = panesRepository.findAll();
            thisResponse.setData(panesList);
        }catch (Exception e){

        }
        return thisResponse;
    }
}
